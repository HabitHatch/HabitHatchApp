package com.habithatch.demo.repositories

import androidx.compose.ui.graphics.Color
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery
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

    private val normalPriority = GoalModel.Priority(
            label = "Normal",
            importance = 10,
            iconResourceId = 1,
            getColor = { Color.Green }
    )
    private val highPriority: GoalModel.Priority = GoalModel.Priority(
            label = "High",
            importance = 20,
            iconResourceId = 2,
            getColor = { Color.Red }
    )
    private val inProgressStatus = GoalModel.Status(
            label = "In Progress",
            stepNumber = 10,
            isDone = false
    )
    private val doneStatus: GoalModel.Status = GoalModel.Status(
            label = "Done",
            stepNumber = 20,
            isDone = true
    )

    @Before
    fun setup() {
        goalDao = mockk()

        statusProvider = object : GoalStatusProvider {
            override val statuses = listOf(inProgressStatus, doneStatus)
            override val defaultStatus = inProgressStatus
            override fun getStatusByLabel(label: String) = statuses.first { it.label == label }
        }

        priorityProvider = object : GoalPriorityProvider {
            override val priorities = listOf(normalPriority, highPriority)
            override val defaultPriority = normalPriority
            override fun getPriorityByLabel(label: String) = priorities.first { it.label == label }
        }
        goalMapper = GoalMapper(statusProvider, priorityProvider)

        goalRepository = GoalRepository(
                goalDao = goalDao,
                goalMapper = goalMapper,
                statusesProvider = statusProvider
        )
    }


    private suspend fun assertThatGoalFilterMatches(
        matchingGoals: List<GoalModel>,
        notMatchingGoals: List<GoalModel>,
        filter: GoalFilter
    ) {
        val goalQuery = GoalQuery(
                filter = filter,
                sortOptions = emptyList(),
                defaultSortConfig = SortConfig<GoalModel>(compareBy { it.id })
        )
        val goalEntities = (matchingGoals + notMatchingGoals).map(goalMapper::toEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        val result: List<GoalModel> = goalRepository.getQueriedGoals(goalQuery).first()
        assertThat(result).containsExactlyElementsIn(matchingGoals)
    }

    private suspend fun getQueriedGoals(
        goals: List<GoalModel>,
        goalQuery: GoalQuery
    ): List<GoalModel> {

        val goalEntities = goals.map(goalMapper::toEntity)
        coEvery { goalDao.getAll() } returns flowOf(goalEntities)

        return goalRepository.getQueriedGoals(goalQuery).first()
    }

    @Test
    fun `changeGoalStatusToNextInCycle should mark goal as done if not done`() = runBlocking {
        // Arrange
        val goalModel = GoalModel(
                id = 1,
                title = "goal",
                status = inProgressStatus,
                priority = normalPriority
        )
        val goalEntity = goalMapper.toEntity(goalModel)
        coEvery { goalDao.getGoalById(goalEntity.id) } returns flowOf(goalEntity)
        coEvery { goalDao.update(any()) } returns Unit

        // Act

        goalRepository.changeGoalStatusToNextInCycle(goalModel.id!!)

        // Assert

        val updatedGoalModel = goalModel.updateStatus(doneStatus)
        coVerify { goalDao.update(goalMapper.toEntity(updatedGoalModel)) }
    }

    @Test
    fun `changeGoalStatusToNextInCycle should mark goal as not done if done`() = runBlocking {
        // Arrange
        val goalModel = GoalModel(id = 1, "goal", doneStatus, normalPriority)
        val goalEntity = goalMapper.toEntity(goalModel)
        coEvery { goalDao.getGoalById(goalEntity.id) } returns flowOf(goalEntity)
        coEvery { goalDao.update(any()) } returns Unit

        // Act
        goalRepository.changeGoalStatusToNextInCycle(goalModel.id!!)

        // Assert
        val updatedGoalModel = goalModel.updateStatus(inProgressStatus)
        coVerify { goalDao.update(goalMapper.toEntity(updatedGoalModel)) }
    }


    @Test
    fun `getQueriedGoals() should return all goals when no filter is applied`() {
        runBlocking {
            // Arrange
            val matchingGoals = listOf(
                    GoalModel(1, "Goal match 1", inProgressStatus, normalPriority),
                    GoalModel(2, "Goal match 2", inProgressStatus, normalPriority),
                    GoalModel(3, "Goal match 3", doneStatus, normalPriority),
            )
            val filter = GoalFilter.Builder(priorityProvider, statusProvider)
                .createMatchAll()
                .build()

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, emptyList(), filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching the search query`() {
        runBlocking {
            // Arrange
            val matchingGoals = listOf(
                    GoalModel(id = 1, "Goal match 1", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "Goal match 2", inProgressStatus, normalPriority),
            )
            val notMatchingGoals = listOf(
                    GoalModel(id = 2, "not matching", inProgressStatus, normalPriority),
            )
            val filter = GoalFilter.Builder(priorityProvider, statusProvider)
                .createMatchAll()
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
            val notMatchingGoals = listOf(
                    GoalModel(id = 1, "not matching 1", inProgressStatus, normalPriority),
                    GoalModel(id = 2, "not matching 2", inProgressStatus, normalPriority),
            )

            val filter = GoalFilter.Builder(priorityProvider, statusProvider)
                .createMatchAll()
                .setSearchQuery("nothing")
                .build()

            // Act & Assert
            assertThatGoalFilterMatches(emptyList(), notMatchingGoals, filter)
        }
    }

    @Test
    fun `getQueriedGoals() should return goals matching priorities`() = runBlocking {
        val matchingGoals = listOf(
                GoalModel(id = 1, "Goal 1", inProgressStatus, normalPriority),
                GoalModel(id = 2, "Goal 2", doneStatus, normalPriority)
        )
        val notMatchingGoals = listOf(
                GoalModel(id = 3, "Not Matching", inProgressStatus, highPriority)
        )

        val filter =
            GoalFilter.Builder(priorityProvider, statusProvider)
                .setPriorityVisibility(normalPriority, true)
                .setPriorityVisibility(highPriority, false)
                .setStatusVisibility(inProgressStatus, true)
                .setStatusVisibility(doneStatus, true)
                .build()


        assertThatGoalFilterMatches(matchingGoals, notMatchingGoals, filter)
    }

    @Test
    fun `getQueriedGoals() should return goals sorted by comparator`() = runBlocking {
        val goals = listOf(
                GoalModel(id = 1, "A Goal", inProgressStatus, normalPriority),
                GoalModel(id = 2, "B Goal", inProgressStatus, highPriority),
                GoalModel(id = 3, "C Goal", inProgressStatus, normalPriority),
        )

        val filter = GoalFilter.Builder(priorityProvider, statusProvider)
            .createMatchAll()
            .build()

        val goalQuery = GoalQuery(
                filter = filter,
                sortOptions = emptyList(),
                defaultSortConfig = SortConfig<GoalModel>(compareBy { it.priority.importance })
        )

        val sortedGoals = goals.sortedWith(
                compareBy<GoalModel> { it.priority.importance }.thenBy { it.title }
        )
        assertThat(getQueriedGoals(goals, goalQuery)).isEqualTo(sortedGoals)
    }

    @Test
    fun `getQueriedGoals() should return filtered and sorted goals`() = runBlocking {
        val matchingGoals = listOf(
                GoalModel(id = 1, "A Goal 1", inProgressStatus, normalPriority),
                GoalModel(id = 2, "B Goal 2", inProgressStatus, highPriority),
        )

        val notMatchingGoals = listOf(
                GoalModel(id = 3, "Goal 3", doneStatus, normalPriority),
        )

        val filter = GoalFilter.Builder(priorityProvider, statusProvider)
            .createMatchAll()
            .build()

        val goalQuery = GoalQuery(
                filter = filter,
                sortOptions = emptyList(),
                defaultSortConfig = SortConfig<GoalModel>(compareBy { it.priority.importance })
        )
        val allGoals = matchingGoals + notMatchingGoals
        val sortedGoals = allGoals.sortedWith(
                compareBy<GoalModel> { it.priority.importance }.thenBy { it.title }
        )
        assertThat(getQueriedGoals(allGoals, goalQuery)).isEqualTo(sortedGoals)
    }
}