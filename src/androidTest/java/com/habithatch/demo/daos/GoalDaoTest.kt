package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.HabitDao
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.entities.HabitEntity
import java.time.Instant
import java.util.UUID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class HabitDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var habitDao: HabitDao

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database =
            Room
                .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        habitDao = database.habitDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun getHabitById_shouldGetAHabitById_whenHabitExists() {
        runBlocking {
            // Arrange
            val habit =
                HabitEntity(
                    id = 1,
                    userId = UUID.randomUUID(),
                    title = "Drink water",
                    statusLabel = "In Progress",
                    priorityLabel = "Normal",
                    createdAt = Instant.now(),
                )
            habitDao.insert(habit)

            // Act
            val result = habitDao.getHabitById(habit.id).first()

            // Assert
            assertThat(result).isEqualTo(habit)
        }
    }

    @Test
    fun getAll_shouldRetrieveAllHabitsStored() {
        runBlocking {
            // Arrange
            val habits =
                listOf(
                    HabitEntity(
                        id = 1,
                        userId = UUID.randomUUID(),
                        title = "Drink water",
                        statusLabel = "In Progress",
                        priorityLabel = "Normal",
                        createdAt = Instant.now(),
                    ),
                    HabitEntity(
                        id = 2,
                        userId = UUID.randomUUID(),
                        title = "Eat vegetables",
                        statusLabel = "In Progress",
                        priorityLabel = "High",
                        createdAt = Instant.now(),
                    ),
                )
            habits.forEach { habitDao.insert(it) }

            // Act
            val activeHabits = habitDao.getAll().first()

            // Assert
            assertThat(activeHabits).containsExactlyElementsIn(habits)
        }
    }
}
