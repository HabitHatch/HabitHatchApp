package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.User
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
    fun `insert() should add a user to the database`() {
        runBlocking {
            // Arrange
            val user = User(uid = "some-uid", petId = 1)

            // Act
            userDao.insert(user)
            val retrievedUser = userDao.getUser()

            // Assert
            assertThat(retrievedUser?.uid).isEqualTo(user.uid)
            assertThat(retrievedUser?.petId).isEqualTo(user.petId)
        }
    }

    @Test
    fun `delete() should remove the user from the database`() {
        runBlocking {
            // Arrange
            val user = User(uid = "some-uid", petId = 1)
            userDao.insert(user)

            // Act
            userDao.delete()

            // Assert
            val retrievedUser = userDao.getUser()
            assertThat(retrievedUser).isNull()
        }
    }
}
