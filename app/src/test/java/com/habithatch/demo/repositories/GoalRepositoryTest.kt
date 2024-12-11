package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.daos.GoalDao
import com.habithatch.demo.entities.Goal
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GoalRepositoryTest {
    private val mockGoalDao = mockk<GoalDao>()
    private val repository = GoalRepository(mockGoalDao)

    @Test
    fun `getActiveGoals should return only active goals`() {
        runBlocking {
            val goals = listOf(
                Goal(id = 1, title = "Goal 1", isDone = false),
                Goal(id = 2, title = "Goal 2", isDone = true)
            )
            coEvery { mockGoalDao.getAllActive() } returns flow {
                emit(goals.filter { !it.isDone })
            }

            // Act
            val activeGoals = repository.getAllActive().first()

            // Assert
            assertThat(activeGoals).containsExactly(
                Goal(id = 1, title = "Goal 1", isDone = false)
            )
            coVerify { mockGoalDao.getAllActive() }
        }
    }
}
