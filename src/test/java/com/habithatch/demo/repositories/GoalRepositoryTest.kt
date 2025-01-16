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
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.UserModel
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import io.mockk.coEvery
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
                UserModel(
                    uuid = userId,
                    pet =
                        Pet(
                            id = 1,
                            name = "",
                            coverImage = 1,
                        ),
                ),
            )
        goalRepository =
            GoalRepository(
                goalDao = goalDao,
                goalMapper = goalMapper,
            )
        coEvery { goalDao.update(any(), any(), any(), any()) } returns Unit
    }

    private fun asEntity(goal: GoalModel): GoalEntity = goalMapper.asEntity(goal)

    private suspend fun assertFilterMatches(
        matching: Collection<GoalModel>,
        notMatching: Collection<GoalModel>,
        filterBuilder: GoalFilter.Builder,
    ) {
        val goalQuery =
            GoalQuery(
                filterBuilder = filterBuilder,
                sortOptions = emptyList(),
                defaultComparator = compareBy { it.title.lowercase() },
            )
        val goalEntities = (matching + notMatching).map(::asEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        val result: List<GoalModel> = goalRepository.search(goalQuery).first()
        assertThat(result).containsExactlyElementsIn(matching)
    }

    private suspend fun getQueriedGoals(
        goals: List<GoalModel>,
        goalQuery: GoalQuery,
    ): List<GoalModel> {
        val goalEntities = goals.map(::asEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        return goalRepository.search(goalQuery).first()
    }

    @Test
    fun `getQueriedGoals() should return all goals when no filter is applied`() {
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "match 1"),
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "match 2"),
                    goalFactory.createDraft(userId, doneStatus, normalPriority, "match 3"),
                )

            // Act & Assert
            assertFilterMatches(matching = matchingGoals, notMatching = emptyList(), matchAllBuilder)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching the search query`() {
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "match 1"),
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "match 2"),
                )
            val notMatchingGoals =
                listOf(
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "not matching"),
                )
            val filterBuilder =
                matchAllBuilder
                    .setSearchQuery("Goal")

            // Act & Assert
            assertFilterMatches(matchingGoals, notMatchingGoals, filterBuilder)
        }
    }

    @Test
    fun `getQueriedGoals() should return no goals when search query does not match`() {
        runBlocking {
            // Arrange
            val notMatchingGoals =
                listOf(
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "not matching 1"),
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "not matching 2"),
                )

            val filterBuilder =
                matchAllBuilder
                    .setSearchQuery("nothing")

            // Act & Assert
            assertFilterMatches(emptyList(), notMatchingGoals, filterBuilder)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching priorities`() =
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "Goal 1"),
                    goalFactory.createDraft(userId, doneStatus, normalPriority, "Goal 2"),
                )
            val notMatchingGoals =
                listOf(goalFactory.createDraft(userId, inProgressStatus, highPriority, "Not Matching"))

            val filterBuilder =
                matchAllBuilder
                    .priorityVisibility(highPriority, false)

            // Act & Assert
            assertFilterMatches(matchingGoals, notMatchingGoals, filterBuilder)
        }

    @Test
    fun `getQueriedGoals() should return goals sorted by comparator`() =
        runBlocking {
            // Arrange
            val goals =
                listOf(
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "A Goal"),
                    goalFactory.createDraft(userId, inProgressStatus, highPriority, "B Goal"),
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "C Goal"),
                )

            val goalQuery =
                GoalQuery(
                    filterBuilder = matchAllBuilder,
                    sortOptions = emptyList(),
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
                    goalFactory.createDraft(userId, inProgressStatus, normalPriority, "A Goal 1"),
                    goalFactory.createDraft(userId, inProgressStatus, highPriority, "B Goal 2"),
                )

            val notMatchingGoals =
                listOf(
                    goalFactory.createDraft(userId, doneStatus, normalPriority, "Goal 3"),
                )

            val filterBuilder =
                GoalFilter
                    .Builder
                    .matchAllBuilder(priorityProvider, statusProvider)
                    .statusVisibility(doneStatus, false)

            val goalQuery =
                GoalQuery(
                    filterBuilder = filterBuilder,
                    sortOptions = emptyList(),
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
