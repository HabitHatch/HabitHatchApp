package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        userDao = database.userDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insert_shouldAddUserToDatabase() {
        runBlocking {
            // Arrange
            val user = User(pet = Pet(name = "Test Pet", imageRes = -1))

            // Act
            userDao.insert(user)
            val retrievedUser = userDao.getUser().first()

            // Assert
            assertThat(retrievedUser?.uuid).isEqualTo(user.uuid)
            assertThat(retrievedUser?.pet).isEqualTo(user.pet)
        }
    }

    @Test
    fun delete_shouldRemoveAllUsersFromDatabase() {
        runBlocking {
            // Arrange
            val user1 = User(pet = Pet(name = "Test Pet", imageRes = -1))
            val user2 = User(pet = Pet(name = "Test Pet", imageRes = -1))
            userDao.insert(user1)
            userDao.insert(user2)

            // Act
            userDao.delete()

            // Assert
            val retrievedUser = userDao.getUser().first()
            assertThat(retrievedUser).isNull()
        }
    }
}
