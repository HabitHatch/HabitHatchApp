package com.habithatch.demo.repositories

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.User
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

// TODO: Make Unit Test
class UserRepositoryTest {

    private lateinit var database: AppDatabase
    private lateinit var userRepository: UserRepository

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        val userDao = database.userDao()
        userRepository = UserRepository(userDao)
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `createUser() should add a User, when no User exists`() {
        runBlocking {
            // Arrange
            val user = User(petId = 1)

            // Act
            val createdUser = userRepository.createUser(user)

            // Assert
            assertThat(createdUser).isEqualTo(user)
            assertThat(userRepository.getUser()).isEqualTo(user)
        }
    }


    @Test()
    fun `createUser() should throw an IllegalStateException, when a User already exists`() {
        runBlocking {
            // Arrange
            val user1 = User(petId = 1)
            val user2 = User(petId = 2)
            userRepository.createUser(user1)

            // Act
            val exception = runCatching {
                userRepository.createUser(user2)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }

    @Test
    fun `updateUser() should replace existing User, when User exists`() {
        runBlocking {
            // Arrange
            val user1 = User(petId = 1)
            val user2 = User(uid = user1.uid, petId = 2)
            userRepository.createUser(user1)

            // Act
            userRepository.updateUser(user2)

            // Assert
            assertThat(userRepository.getUser()).isEqualTo(user2)
        }
    }

    @Test()
    fun `updateUser() should throw IllegalStateException, when no User exists`() {
        runBlocking {
            // Arrange
            val user1 = User(petId = 1)

            // Act
            val exception = runCatching {
                userRepository.updateUser(user1)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }

    @Test()
    fun `createUser() should throw IllegalArgumentException, when invalid UUID format`() {
        runBlocking {
            // Arrange
            val user1 = User(uid = "invalid-uid", petId = 1)

            // Act
            val exception = runCatching {
                userRepository.createUser(user1)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test()
    fun `deleteUser() should remove the User`(){
        runBlocking{
            // Arrange
            val user1 = User(petId = 1)
            userRepository.createUser(user1)
            // Act
            userRepository.deleteUser()
            // Assert
            assertThat(userRepository.getUser()).isNull()
        }
    }
}
