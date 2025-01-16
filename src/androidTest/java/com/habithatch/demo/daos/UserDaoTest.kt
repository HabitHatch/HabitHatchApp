package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.UserEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao
    private val someUser = UserEntity(pet = Pet(name = "Pet 1", petMoodAnimations = 1001))
    private val anotherUser = UserEntity(pet = Pet(name = "Pet 2", petMoodAnimations = 1002))

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database =
            Room
                .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()

        userDao = database.userDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun getUser_shouldEmitUser_whenAnyUserExists() {
        runBlocking {
            // Act
            userDao.insert(someUser)
            val retrievedUser = userDao.getUser().first()

            // Assert
            assertThat(retrievedUser).isEqualTo(someUser)
        }
    }

    @Test
    fun getUser_shouldEmitNull_whenNoUserExists() {
        runBlocking {
            // Act
            val retrievedUser = userDao.getUser().first()

            // Assert
            assertThat(retrievedUser).isNull()
        }
    }

    @Test
    fun delete_All_shouldRemoveAllUsersFromDatabase() {
        runBlocking {
            // Arrange
            userDao.insert(someUser)
            userDao.insert(anotherUser)

            // Act
            userDao.deleteAll()

            // Assert
            val retrievedUser = userDao.getUser().first()
            assertThat(retrievedUser).isNull()
        }
    }
}
