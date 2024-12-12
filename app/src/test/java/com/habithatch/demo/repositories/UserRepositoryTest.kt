package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.repositories.InvalidUuidFormatException
import com.habithatch.demo.data.repositories.UserAlreadyExistsException
import com.habithatch.demo.data.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UserRepositoryTest {
    private val userDao = mockk<UserDao>()
    private val userRepository = UserRepository(userDao)


    @Test
    fun `createUser() should add a User, when no User exists`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow { emit(null) }
            coEvery { userDao.insert(any()) } returns Unit
            val user = User(pet = Pet(name = "Pet1", imageRes = -1))

            // Act
            val createdUser = userRepository.createUser(user)

            // Assert
            assertThat(createdUser).isEqualTo(user)
        }
    }


    @Test()
    fun `createUser() should throw an IllegalStateException, when a User already exists`() {
        runBlocking {
            // Arrange

            coEvery { userDao.getUser() } returns flow {
                emit(User(pet = Pet(name = "Pet1", imageRes = -1)))
            }
            coEvery { userDao.insert(any()) } returns Unit
            val user = User(pet = Pet(name = "Pet2", imageRes = -1))

            // Act
            val exception = runCatching {
                userRepository.createUser(user)
            }.exceptionOrNull()

            // Assert
            assertThat(exception).isInstanceOf(UserAlreadyExistsException::class.java)
        }
    }

    @Test()
    fun `createUser() should throw IllegalArgumentException, when invalid UUID format`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow { emit(null) }
            coEvery { userDao.insert(any()) } returns Unit
            val user1 = User(uuid = "invalid-uid", pet = Pet(name = "Pet1", imageRes = -1))

            // Act
            val exception = runCatching {
                userRepository.createUser(user1)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(InvalidUuidFormatException::class.java)
        }
    }

    @Test()
    fun `deleteUser() should remove the User`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow {
                emit(User(pet = Pet(name = "Pet1", imageRes = -1)))
            }
            coEvery { userDao.delete() } returns Unit

            // Act
            userRepository.deleteUser()
            // Assert
            coVerify { userDao.delete() }
        }
    }
}
