package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.repositories.GoalRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GoalRepositoryTest {

    private lateinit var goalDao: GoalDao
    private lateinit var goalRepository: GoalRepository

    @Before
    fun setup() {
        goalDao = mockk()
        goalRepository = GoalRepository(goalDao)
        coEvery { goalDao.update(any()) } returns Unit
    }

    private suspend fun assertThatGoalFilterMatches(
        matchingGoals: List<Goal>,
        notMatchingGoals: List<Goal>,
        filter: GoalFilter
    ) {
        // Arrange
        val goals = matchingGoals + notMatchingGoals
        coEvery { goalDao.getAll() } returns flowOf(goals)

        // Act
        val result = goalRepository.getFilteredGoals(filter).toList().flatten()

        // Assert
        assertThat(result).containsExactlyElementsIn(matchingGoals)
    }

    @Test
    fun `toggleGoalDone() should mark goal as done when goal not done`() {
        runBlocking {
            // Arrange
            val goal = Goal(title = "goal", doneState = GoalDoneState.UNDONE)

            coEvery { goalDao.getGoalById(goal.id) } returns goal

            // Act
            goalRepository.toggleGoalDone(goal.id)

            // Assert
            val updatedGoal = goal.copy(doneState = GoalDoneState.DONE)
            coVerify { goalDao.update(updatedGoal) }
        }
    }

    @Test
    fun `toggleGoalDone() should mark goal as not done when goal done`() {
        runBlocking {
            // Arrange
            val goal = Goal(title = "goal", doneState = GoalDoneState.DONE)
            coEvery { goalDao.getGoalById(goal.id) } returns goal

            // Act
            goalRepository.toggleGoalDone(goal.id)

            // Assert
            val updatedGoal = goal.copy(doneState = GoalDoneState.UNDONE)
            coVerify { goalDao.update(updatedGoal) }
        }
    }

    @Test
    fun `getFilteredGoals() should return goals matching the priorities`() {
        runBlocking {
            // Arrange
            val matchingGoals = listOf(
                    Goal(title = "Goal 1", priority = GoalPriority.NORMAL),
                    Goal(title = "Goal 2", priority = GoalPriority.NORMAL)

            )
            val notMatchingGoals = listOf(
                    Goal(title = "not matching", priority = GoalPriority.HIGH),
            )

            val filter = GoalFilter.matchAllFilter().copy(
                    priorityVisibleMap = mapOf(
                            GoalPriority.NORMAL to true,
                            GoalPriority.HIGH to false,
                    )
            )

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, notMatchingGoals, filter)
        }
    }

    @Test
    fun `getFilteredGoals() should return all goals when no filter is applied`() {
        runBlocking {
            // Arrange
            val matchingGoals = listOf(
                    Goal(title = "Goal 1"),
                    Goal(title = "Goal 2"),
                    Goal(title = "Goal 3")
            )
            val filter = GoalFilter.matchAllFilter()

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, emptyList(), filter)
        }
    }

    @Test
    fun `getFilteredGoals() should return goals matching the search query`() {
        runBlocking {
            // Arrange
            val matchingGoals = listOf(
                    Goal(title = "Goal match 1"),
                    Goal(title = "Goal match 2")

            )
            val notMatchingGoals = listOf(
                    Goal(id = 2, title = "not matching"),
            )
            val filter = GoalFilter.matchAllFilter().copy(
                    searchQuery = "Goal"
            )

            // Act & Assert
            assertThatGoalFilterMatches(matchingGoals, notMatchingGoals, filter)
        }
    }

    @Test
    fun `getFilteredGoals() should return no goals when search query does not match`() {
        runBlocking {
            // Arrange
            val notMatchingGoals = listOf(
                    Goal(title = "Read book",),
                    Goal(title = "Write book")
            )
            coEvery { goalDao.getAll() } returns flowOf(notMatchingGoals)

            val filter = GoalFilter.matchAllFilter().copy(
                    searchQuery = "not matching query"
            )

            // Act & Assert
            assertThatGoalFilterMatches(emptyList(), notMatchingGoals, filter)
        }
    }
}
