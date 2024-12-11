package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.data.entities.Goal
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GoalDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var goalDao: GoalDao

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        goalDao = database.goalDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `insert() should store goal in database`() {
        runBlocking {
            // Arrange
            val goal = Goal(id = 1, title = "Drink water")

            // Act
            goalDao.insert(goal)
            val result = goalDao.getGoalById(1)

            // Assert
            assertThat(result).isEqualTo(goal)
        }
    }

    @Test
    fun `update() should change goal in database`() {
        runBlocking {
            // Arrange
            val goal = Goal(id = 1, title = "Read book", isDone = false)
            val changedGoal = goal.copy(isDone = true)
            goalDao.insert(goal)

            // Act
            goalDao.update(changedGoal)
            val result = goalDao.getGoalById(1)

            // Assert
            assertThat(result).isEqualTo(goal)
        }
    }

    @Test
    fun `getAllActive() should retrieve all goals not done`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                Goal(id = 1, title = "Drink water"),
                Goal(id = 3, title = "Learn how to code", isDone = true),
            )
            goals.forEach { goalDao.insert(it) }

            // Act
            val activeGoals = goalDao.getAllActive().first()

            // Assert
            assertThat(activeGoals).containsAtLeastElementsIn(
                listOf(
                    Goal(id = 1, title = "Drink water"),
                    Goal(id = 2, title = "Read book")
                )
            )
        }
    }

    @Test
    fun `getAll() should retrieve all goals stored`() {
        runBlocking {
            // Arrange
            val goals = listOf(
                Goal(id = 2, title = "Read book"),
                Goal(id = 3, title = "Learn how to code", isDone = true),
            )
            goals.forEach { goalDao.insert(it) }

            // Act
            val activeGoals = goalDao.getAll().first()

            // Assert
            assertThat(activeGoals).containsExactlyElementsIn(goals)
        }
    }
}
