package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.entities.GoalEntity
import java.time.Instant
import java.util.UUID
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
        database =
            Room
                .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        goalDao = database.goalDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun getGoalById_shouldGetAGoalById_whenGoalExists() {
        runBlocking {
            // Arrange
            val goal =
                GoalEntity(
                    id = 1,
                    userId = UUID.randomUUID(),
                    title = "Drink water",
                    statusLabel = "In Progress",
                    priorityLabel = "Normal",
                    createdAt = Instant.now(),
                )
            goalDao.insert(goal)

            // Act
            val result = goalDao.getGoalById(goal.id).first()

            // Assert
            assertThat(result).isEqualTo(goal)
        }
    }

    @Test
    fun getAll_shouldRetrieveAllGoalsStored() {
        runBlocking {
            // Arrange
            val goals =
                listOf(
                    GoalEntity(
                        id = 1,
                        userId = UUID.randomUUID(),
                        title = "Drink water",
                        statusLabel = "In Progress",
                        priorityLabel = "Normal",
                        createdAt = Instant.now(),
                    ),
                    GoalEntity(
                        id = 2,
                        userId = UUID.randomUUID(),
                        title = "Eat vegetables",
                        statusLabel = "In Progress",
                        priorityLabel = "High",
                        createdAt = Instant.now(),
                    ),
                )
            goals.forEach { goalDao.insert(it) }

            // Act
            val activeGoals = goalDao.getAll().first()

            // Assert
            assertThat(activeGoals).containsExactlyElementsIn(goals)
        }
    }
}
