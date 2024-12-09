package com.habithatch.demo;

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
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
    fun onlyOneUserCanExist() = runBlocking {
        // Arrange
        val pet1 = Pet(name = "Pet1", imageRes = 0)
        val firstUser = User(pet = pet1)

        val pet2 = Pet(name = "Pet2", imageRes = 0)
        val secondUser = User(pet = pet2)

        // Insert the first user
        userDao.insertOrUpdateUser(firstUser)

        // Verify first user exists
        val retrievedUser1 = userDao.getUser()
        assertThat(retrievedUser1?.pet?.name).isEqualTo(pet1.name)
        assertThat(retrievedUser1?.id).isEqualTo(1)

        // Insert a second user
        userDao.insertOrUpdateUser(secondUser)

        // Verify that the second user replaced the first
        val retrievedUser2 = userDao.getUser()
        assertThat(retrievedUser2?.id).isEqualTo(1)
        assertThat(retrievedUser2?.pet?.name).isEqualTo(pet2.name)
    }
    @Test
    fun insertOrUpdateUser() = runBlocking {
        // Arrange
        val pet1 = Pet(name = "Pet1", imageRes = 0)
        val firstUser = User(pet = pet1)

        // Act
        userDao.insertOrUpdateUser(firstUser)

        // Assert
        var retrievedUser = userDao.getUser()
        assertThat(retrievedUser?.pet?.name).isEqualTo(pet1.name)
        assertThat(retrievedUser?.id).isEqualTo(1)
    }
}
