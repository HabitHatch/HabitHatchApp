package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.Goal
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
    }

    @Test
    fun `toggleGoalDone() should toggle the isDone state of a goal`() {
        runBlocking {
            // Arrange
            val goal = Goal(id = 1, title = "Read book", isDone = false)
            val updatedGoal = goal.copy(isDone = true)
            coEvery { goalDao.getGoalById(goal.id) } returns goal
            coEvery { goalDao.update(updatedGoal) } returns Unit

            // Act
            goalRepository.toggleGoalDone(goal.id)

            // Assert
            coVerify { goalDao.update(updatedGoal) }
        }
    }

    @Test
    fun `toggleGoalDone() should toggle the isDone state back when already done`() {
        runBlocking {
            // Arrange
            val goal = Goal(id = 1, title = "Read book", isDone = true)
            val updatedGoal = goal.copy(isDone = false)
            coEvery { goalDao.getGoalById(goal.id) } returns goal
            coEvery { goalDao.update(updatedGoal) } returns Unit

            // Act
            goalRepository.toggleGoalDone(goal.id)

            // Assert
            coVerify { goalDao.update(updatedGoal) }
        }
    }

    @Test
    fun `getFilteredGoals() should return goals matching the priorities`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                    Goal(
                            id = 1,
                            title = "Read book",
                            isDone = false,
                            priority = GoalPriority.NORMAL
                    ),
                    Goal(id = 2, title = "Write book", isDone = true, priority = GoalPriority.HIGH),
                    Goal(id = 3, title = "Buy book", isDone = false, priority = GoalPriority.LOW)
            )
            coEvery { goalDao.getAll() } returns flowOf(goals)

            val filter = GoalFilter.Builder()
                .filterByPriority(GoalPriority.NORMAL, GoalPriority.LOW)
                .build()

            // Act
            val result = goalRepository.getFilteredGoals(filter).toList().flatten()

            // Assert
            assertThat(result).containsExactly(
                    Goal(
                            id = 1,
                            title = "Read book",
                            isDone = false,
                            priority = GoalPriority.NORMAL
                    ),
                    Goal(id = 3, title = "Buy book", isDone = false, priority = GoalPriority.LOW)
            )
        }
    }

    @Test
    fun `getFilteredGoals() should return all goals when no filter is applied`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                    Goal(
                            id = 1,
                            title = "Read book",
                            isDone = false,
                            priority = GoalPriority.NORMAL
                    ),
                    Goal(id = 2, title = "Write book", isDone = true, priority = GoalPriority.HIGH),
                    Goal(id = 3, title = "Buy book", isDone = false, priority = GoalPriority.LOW)
            )
            coEvery { goalDao.getAll() } returns flowOf(goals)

            val filter = GoalFilter.matchAllFilter

            // Act
            val result = goalRepository.getFilteredGoals(filter).toList().flatten()

            // Assert
            assertThat(result).isEqualTo(goals)
        }
    }

    @Test
    fun `getFilteredGoals() should return goals matching the search query`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                    Goal(
                            id = 1,
                            title = "Read book",
                            isDone = false,
                            priority = GoalPriority.NORMAL
                    ),
                    Goal(
                            id = 2,
                            title = "Write notes",
                            isDone = true,
                            priority = GoalPriority.HIGH
                    ),
                    Goal(id = 3, title = "Buy book", isDone = false, priority = GoalPriority.LOW)
            )
            coEvery { goalDao.getAll() } returns flowOf(goals)

            val filter = GoalFilter.Builder()
                .filterBySearchQuery("book")
                .build()

            // Act
            val result = goalRepository.getFilteredGoals(filter).toList().flatten()

            // Assert
            assertThat(result).containsExactly(
                    Goal(
                            id = 1,
                            title = "Read book",
                            isDone = false,
                            priority = GoalPriority.NORMAL
                    ),
                    Goal(id = 3, title = "Buy book", isDone = false, priority = GoalPriority.LOW)
            )
        }
    }

    @Test
    fun `getFilteredGoals() should return no goals if filter excludes all`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                    Goal(
                            id = 1,
                            title = "Read book",
                            isDone = false,
                            priority = GoalPriority.NORMAL
                    ),
                    Goal(id = 2, title = "Write book", isDone = true, priority = GoalPriority.HIGH)
            )
            coEvery { goalDao.getAll() } returns flowOf(goals)

            val filter = GoalFilter.Builder()
                .filterBySearchQuery("non-existent")
                .build()

            // Act
            val result = goalRepository.getFilteredGoals(filter).toList().flatten()

            // Assert
            assertThat(result).isEmpty()
        }
    }
}
