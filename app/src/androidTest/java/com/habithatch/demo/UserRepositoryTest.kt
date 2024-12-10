package com.habithatch.demo

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.User
import com.habithatch.demo.repositories.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

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
    fun `create User should insert User`() {
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
    fun `create User when User exists should throw Exception`() {
        runBlocking {
            // Arrange
            val user1 = User(petId = 1)
            val user2 = User(petId = 2)
            userRepository.createUser(user1)

            // Act
            val exception = kotlin.runCatching {
                userRepository.createUser(user2)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }

    @Test
    fun `update User should replace existing User`() {
        runBlocking {
            // Arrange
            val user1 = User(petId = 1)
            val user2 = User(petId = 2)
            userRepository.createUser(user1)

            // Act
            userRepository.updateUser(user2)

            // Assert
            assertThat(userRepository.getUser()).isEqualTo(user2)
        }
    }

    @Test()
    fun `update User when no User exists should throw Exception`() {
        runBlocking {
            // Arrange
            val user1 = User(petId = 1)

            // Act
            val exception = kotlin.runCatching {
                userRepository.createUser(user1)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }

    @Test()
    fun `create user with invalid uuid should throw exception`() {
        runBlocking {
            // Arrange
            val user1 = User(uid = "invalid-uid", petId = 1)

            // Act
            val exception = kotlin.runCatching {
                userRepository.createUser(user1)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }

    @Test()
    fun `delete User should remove User`(){
        runBlocking{
            // Arrange
            val user1 = User(uid = "invalid-uid", petId = 1)
            userRepository.createUser(user1)
            // Act
            userRepository.deleteUser()
            // Assert
            assertThat(userRepository.getUser()).isNull()
        }
    }
}
