package com.habithatch.demo.repositories

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.Goal
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

// TODO: Make Unit Test
class GoalRepositoryTest {

    private lateinit var database: AppDatabase
    private lateinit var goalRepository: GoalRepository

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        val goalDao = database.goalDao()
        goalRepository = GoalRepository(goalDao)
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `insert() should add the goal to the database`() {
        runBlocking {
            // Arrange
            val goal = Goal(id = 1, title = "Drink water")

            // Act
            goalRepository.insert(goal)
            val goals = goalRepository.getAll()

            // Assert
            assertThat(goals.size).isEqualTo(1)
            assertThat(goals[0]).isEqualTo(goal)
        }
    }

    @Test
    fun `getAllActive() should retrieve all goals not done`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                Goal(id = 1, title = "Drink water"),
                Goal(id = 2, title = "Read book"),
                Goal(id = 3, title = "Learn how to code", isDone = true),
                Goal(id = 4, title = "Go for a walk", isDone = true)
            )
            goals.forEach { goalRepository.insert(it) }

            // Act
            val activeGoals = goalRepository.getAllActive()

            // Assert
            assertThat(activeGoals).containsAtLeastElementsIn(
                listOf(
                    Goal(id = 1, title = "Drink water"),
                    Goal(id = 2, title = "Read book")
                )
            )
        }
    }
}
