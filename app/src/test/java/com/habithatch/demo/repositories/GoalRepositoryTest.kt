package com.habithatch.demo.repositories

import androidx.compose.ui.graphics.Color
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.repositories.GoalRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
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
    private lateinit var goalMapper: GoalMapper

    private val normalPriority =
        GoalModel.Priority(
            label = "Normal",
            importance = 10,
            iconResourceId = 1,
            getColor = { Color.Green },
        )
    private val highPriority: GoalModel.Priority =
        GoalModel.Priority(
            label = "High",
            importance = 20,
            iconResourceId = 2,
            getColor = { Color.Red },
        )
    private val inProgressStatus =
        GoalModel.Status(
            label = "In Progress",
            stepNumber = 10,
            isDone = false,
        )
    private val doneStatus: GoalModel.Status =
        GoalModel.Status(
            label = "Done",
            stepNumber = 20,
            isDone = true,
        )

    @Before
    fun setup() {
        goalDao = mockk()

        statusProvider =
            object : GoalStatusProvider {
                override val statuses = listOf(inProgressStatus, doneStatus)
                override val defaultStatus = inProgressStatus

                override fun getStatusByLabel(label: String) = statuses.first { it.label == label }
            }

        priorityProvider =
            object : GoalPriorityProvider {
                override val priorities = listOf(normalPriority, highPriority)
                override val defaultPriority = normalPriority

                override fun getPriorityByLabel(label: String) = priorities.first { it.label == label }
            }
        goalMapper = GoalMapper(statusProvider, priorityProvider)

        goalRepository =
            GoalRepository(
                goalDao = goalDao,
                goalMapper = goalMapper,
                statusesProvider = statusProvider,
            )
        coEvery { goalDao.update(any(), any(), any(), any()) } returns Unit
    }

    private suspend fun assertThatGoalFilterMatches(
        matchingGoals: List<GoalModel>,
        notMatchingGoals: List<GoalModel>,
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
        val goalEntities = (matchingGoals + notMatchingGoals).map(goalMapper::toEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        val result: List<GoalModel> = goalRepository.getQueriedGoals(goalQuery).first()
        assertThat(result).containsExactlyElementsIn(matchingGoals)
    }

    private suspend fun getQueriedGoals(
        goals: List<GoalModel>,
        goalQuery: GoalQuery,
    ): List<GoalModel> {
        val goalEntities = goals.map(goalMapper::toEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        return goalRepository.getQueriedGoals(goalQuery).first()
    }

    @Test
    fun `cycleGoalStatus() should mark goal as done when not done`() =
        runBlocking {
            // Arrange
            val goalModel =
                GoalModel(
                    id = 1,
                    title = "goal",
                    status = inProgressStatus,
                    priority = normalPriority,
                )
            val beforeGoalEntity = goalMapper.toEntity(goalModel)
            coEvery { goalDao.getGoalById(beforeGoalEntity.id) } returns flowOf(beforeGoalEntity)

            // Act

            goalRepository.cycleGoalStatus(goalModel)

            // Assert

            val updatedGoalModel = goalModel.copy(status = doneStatus)
            val goalEntity = goalMapper.toEntity(updatedGoalModel)
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
    fun `changeGoalStatusToNextInCycle should mark goal as not done if done`() =
        runBlocking {
            // Arrange
            val goalModel = GoalModel(id = 1, "goal", doneStatus, normalPriority)
            val goalEntity = goalMapper.toEntity(goalModel)
            coEvery { goalDao.getGoalById(goalEntity.id) } returns flowOf(goalEntity)

            // Act
            goalRepository.cycleGoalStatus(goalModel)

            // Assert
            val updatedGoalModel = goalModel.copy(status = inProgressStatus)
            val updatedGoalEntity = goalMapper.toEntity(updatedGoalModel)
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
                    GoalModel(1, "Goal match 1", inProgressStatus, normalPriority),
                    GoalModel(2, "Goal match 2", inProgressStatus, normalPriority),
                    GoalModel(3, "Goal match 3", doneStatus, normalPriority),
                )
            val filter =
                GoalFilter.Builder
                    .createMatchAllBuilder(priorityProvider, statusProvider)
                    .build()

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, emptyList(), filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching the search query`() {
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    GoalModel(id = 1, "Goal match 1", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "Goal match 2", inProgressStatus, normalPriority),
                )
            val notMatchingGoals =
                listOf(
                    GoalModel(id = 2, "not matching", inProgressStatus, normalPriority),
                )
            val filter =
                GoalFilter
                    .Builder
                    .createMatchAllBuilder(priorityProvider, statusProvider)
                    .setSearchQuery("Goal")
                    .build()

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, notMatchingGoals, filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return no goals when search query does not match`() {
        runBlocking {
            // Arrange
            val notMatchingGoals =
                listOf(
                    GoalModel(id = 1, "not matching 1", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "not matching 2", inProgressStatus, normalPriority),
                )

            val filter =
                GoalFilter
                    .Builder
                    .createMatchAllBuilder(priorityProvider, statusProvider)
                    .setSearchQuery("nothing")
                    .build()

            // Act & Assert
            assertThatGoalFilterMatches(emptyList(), notMatchingGoals, filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching priorities`() =
        runBlocking {
            // Arrange
            val matchingGoals =
                listOf(
                    GoalModel(id = 1, "Goal 1", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "Goal 2", doneStatus, normalPriority),
                )
            val notMatchingGoals =
                listOf(
                    GoalModel(id = 3, "Not Matching", inProgressStatus, highPriority),
                )

            val filter =
                GoalFilter
                    .Builder
                    .createMatchAllBuilder(priorityProvider, statusProvider)
                    .setPriorityVisibility(highPriority, false)
                    .setStatusVisibility(doneStatus, true)
                    .build()

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, notMatchingGoals, filter)
        }

    @Test
    fun `getQueriedGoals() should return goals sorted by comparator`() =
        runBlocking {
            // Arrange
            val goals =
                listOf(
                    GoalModel(id = 1, "A Goal", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "B Goal", inProgressStatus, highPriority),
                    GoalModel(id = 3, "C Goal", inProgressStatus, normalPriority),
                )

            val filter =
                GoalFilter
                    .Builder
                    .createMatchAllBuilder(priorityProvider, statusProvider)
                    .build()

            val goalQuery =
                GoalQuery(
                    filter = filter,
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
                    GoalModel(id = 1, "A Goal 1", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "B Goal 2", inProgressStatus, highPriority),
                )

            val notMatchingGoals =
                listOf(
                    GoalModel(id = 3, "Goal 3", doneStatus, normalPriority),
                )

            val filter =
                GoalFilter
                    .Builder
                    .createMatchAllBuilder(priorityProvider, statusProvider)
                    .setStatusVisibility(doneStatus, false)
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
