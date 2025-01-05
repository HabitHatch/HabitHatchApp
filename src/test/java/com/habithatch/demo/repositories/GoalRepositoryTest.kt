package com.habithatch.demo.repositories

import androidx.compose.ui.graphics.Color
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import java.util.UUID
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GoalRepositoryTest {
    private lateinit var statusProvider: GoalStatusProvider
    private lateinit var priorityProvider: GoalPriorityProvider
    private lateinit var goalDao: GoalDao
    private lateinit var goalRepository: GoalRepository
    private lateinit var userRepository: UserRepository
    private lateinit var goalMapper: GoalMapper

    private val matchAllBuilder = GoalFilter.Builder.matchAllBuilder(priorityProvider, statusProvider)

    private val normalPriority =
        GoalModel.Priority(
            label = "Normal",
            importance = GoalModel.Priority.Importance.Normal,
            iconResourceId = 1,
            getColor = { Color.Green },
        )
    private val highPriority =
        GoalModel.Priority(
            label = "High",
            importance = GoalModel.Priority.Importance.High,
            iconResourceId = 2,
            getColor = { Color.Red },
        )
    private val inProgressStatus =
        GoalModel.Status(
            label = "In Progress",
            stepNumber = 10,
            isDone = false,
        )
    private val doneStatus =
        GoalModel.Status(
            label = "Done",
            stepNumber = 20,
            isDone = true,
        )
    private val userId = UUID.randomUUID()

    @Inject
    lateinit var goalFactory: GoalModel.Factory

    @Before
    fun setup() {
        goalDao = mockk()

        statusProvider =
            object : GoalStatusProvider {
                override val statuses = setOf(inProgressStatus, doneStatus)
                override val defaultStatus = inProgressStatus
            }

        priorityProvider =
            object : GoalPriorityProvider {
                override val priorities = setOf(normalPriority, highPriority)
                override val defaultPriority = normalPriority
            }

        goalMapper = GoalMapper(statusProvider, priorityProvider, goalFactory)

        userRepository = mockk()
        coEvery { userRepository.getUser() } returns
            flowOf(
                User(
                    pet =
                        Pet(
                            name = "pet",
                            imageRes = 1,
                        ),
                ),
            )
        goalRepository =
            GoalRepository(
                goalDao = goalDao,
                goalMapper = goalMapper,
                statusesProvider = statusProvider,
                userRepository = userRepository,
            )
        coEvery { goalDao.update(any(), any(), any(), any()) } returns Unit
    }

    private fun asEntity(goal: GoalModel): GoalEntity = goalMapper.asEntity(goal, userId)

    private suspend fun assertFilterMatches(
        matching: Collection<GoalModel>,
        notMatching: Collection<GoalModel>,
        filter: GoalFilter,
    ) {
        val goalQuery =
            GoalQuery(
                filter = filter,
                sortOptions = emptyList(),
                statusProvider = statusProvider,
                priorityProvider = priorityProvider,
                defaultComparator = compareBy { it.title.lowercase() },
            )
        val goalEntities = (matching + notMatching).map(::asEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        val result: List<GoalModel> = goalRepository.getQueriedGoals(goalQuery).first()
        assertThat(result).containsExactlyElementsIn(matching)
    }

    private suspend fun getQueriedGoals(
        goals: List<GoalModel>,
        goalQuery: GoalQuery,
    ): List<GoalModel> {
        val goalEntities = goals.map(::asEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        return goalRepository.getQueriedGoals(goalQuery).first()
    }

    @Test
    fun `cycleGoalStatus() should mark goal as done when not done`() =
        runBlocking {
            // Arrange
            val goalModel =
                goalFactory.createDraft(
                    status = inProgressStatus,
                    priority = normalPriority,
                )
            val beforeGoalEntity = asEntity(goalModel)
            coEvery { goalDao.getGoalById(beforeGoalEntity.id) } returns flowOf(beforeGoalEntity)

            // Act

            goalRepository.cycleGoalStatus(goalModel)

            // Assert

            val updatedGoalModel = goalModel.copy(status = doneStatus)
            val goalEntity = asEntity(updatedGoalModel)
            coVerify {
                goalDao.update(
                    goalEntity.id,
                    goalEntity.title,
                    goalEntity.statusLabel,
                    goalEntity.priorityLabel,
                )
            }
        }

    @Test
    fun `cycleGoalStatus should mark goal as not done if done`() =
        runBlocking {
            // Arrange
            val goalModel = goalFactory.createDraft("goal", doneStatus, normalPriority)
            val goalEntity = asEntity(goalModel)
            coEvery { goalDao.getGoalById(goalEntity.id) } returns flowOf(goalEntity)

            // Act
            goalRepository.cycleGoalStatus(goalModel)

            // Assert
            val updatedGoalEntity = asEntity(goalModel.copy(status = inProgressStatus))
            coVerify {
                goalDao.update(
                    updatedGoalEntity.id,
                    updatedGoalEntity.title,
                    updatedGoalEntity.statusLabel,
                    updatedGoalEntity.priorityLabel,
                )
            }
        }

    @Test
    fun `getQueriedGoals() should return all goals when no filter is applied`() {
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft("match 1", inProgressStatus, normalPriority),
                    goalFactory.createDraft("match 2", inProgressStatus, normalPriority),
                    goalFactory.createDraft("match 3", doneStatus, normalPriority),
                )
            val filter = matchAllBuilder.build()

            // Act & Assert
            assertFilterMatches(matching = matchingGoals, notMatching = emptyList(), filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching the search query`() {
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft("match 1", inProgressStatus, normalPriority),
                    goalFactory.createDraft("match 2", inProgressStatus, normalPriority),
                )
            val notMatchingGoals =
                listOf(
                    goalFactory.createDraft("not matching", inProgressStatus, normalPriority),
                )
            val filter =
                matchAllBuilder
                    .setSearchQuery("Goal")
                    .build()

            // Act & Assert
            assertFilterMatches(matchingGoals, notMatchingGoals, filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return no goals when search query does not match`() {
        runBlocking {
            // Arrange
            val notMatchingGoals =
                listOf(
                    goalFactory.createDraft("not matching 1", inProgressStatus, normalPriority),
                    goalFactory.createDraft("not matching 2", inProgressStatus, normalPriority),
                )

            val filter =
                matchAllBuilder
                    .setSearchQuery("nothing")
                    .build()

            // Act & Assert
            assertFilterMatches(emptyList(), notMatchingGoals, filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching priorities`() =
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft("Goal 1", inProgressStatus, normalPriority),
                    goalFactory.createDraft("Goal 2", doneStatus, normalPriority),
                )
            val notMatchingGoals = listOf(goalFactory.createDraft("Not Matching", inProgressStatus, highPriority))

            val filter =
                matchAllBuilder
                    .priorityVisibility(highPriority, false)
                    .build()

            // Act & Assert
            assertFilterMatches(matchingGoals, notMatchingGoals, filter)
        }

    @Test
    fun `getQueriedGoals() should return goals sorted by comparator`() =
        runBlocking {
            // Arrange
            val goals =
                listOf(
                    goalFactory.createDraft("A Goal", inProgressStatus, normalPriority),
                    goalFactory.createDraft("B Goal", inProgressStatus, highPriority),
                    goalFactory.createDraft("C Goal", inProgressStatus, normalPriority),
                )

            val goalQuery =
                GoalQuery(
                    filter = matchAllBuilder.build(),
                    sortOptions = emptyList(),
                    priorityProvider = priorityProvider,
                    statusProvider = statusProvider,
                    defaultComparator = compareBy { it.priority.importance },
                )

            val expectedSortedGoals =
                goals.sortedWith(
                    compareBy<GoalModel> { it.priority.importance }.thenBy { it.title },
                )

            // Act

            val result = getQueriedGoals(goals, goalQuery)

            // Assert
            assertThat(result).isEqualTo(expectedSortedGoals)
        }

    @Test
    fun `getQueriedGoals() should return filtered and sorted goals`() =
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft("A Goal 1", inProgressStatus, normalPriority),
                    goalFactory.createDraft("B Goal 2", inProgressStatus, highPriority),
                )

            val notMatchingGoals =
                listOf(
                    goalFactory.createDraft("Goal 3", doneStatus, normalPriority),
                )

            val filter =
                GoalFilter
                    .Builder
                    .matchAllBuilder(priorityProvider, statusProvider)
                    .statusVisibility(doneStatus, false)
                    .build()

            val goalQuery =
                GoalQuery(
                    filter = filter,
                    sortOptions = emptyList(),
                    priorityProvider = priorityProvider,
                    statusProvider = statusProvider,
                    defaultComparator = compareBy { it.priority.importance },
                )
            val sortedGoals =
                matchingGoals.sortedWith(
                    compareBy<GoalModel> { it.priority.importance }.thenBy { it.title.lowercase() },
                )

            val allGoals = matchingGoals + notMatchingGoals

            // Act
            val result = getQueriedGoals(allGoals, goalQuery)

            // Assert
            assertThat(result).isEqualTo(sortedGoals)
        }
}
