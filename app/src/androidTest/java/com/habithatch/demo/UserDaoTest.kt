package com.habithatch.demo;

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.daos.UserDao
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
    fun insertAndRetrieveUser() {
        runBlocking {
            // Arrange
            val user = User(uid = "some-uid", petId = 1)
            userDao.insert(user)

            // Act
            val retrievedUser = userDao.getUser()

            // Assert
            assertThat(retrievedUser?.uid).isEqualTo(user.uid)
            assertThat(retrievedUser?.petId).isEqualTo(user.petId)
        }
    }

    @Test
    fun deleteAll() {
        runBlocking {
            // Arrange
            val user = User(uid = "some-uid", petId = 1)
            userDao.insert(user)

            // Act
            userDao.deleteAll()

            // Assert
            val retrievedUser = userDao.getUser()
            assertThat(retrievedUser).isNull()
        }
    }
}
