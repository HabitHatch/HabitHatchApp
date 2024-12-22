package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.core.exceptions.InvalidUUIdException
import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.data.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {
    private val userDao = mockk<UserDao>()
    private val userRepository = UserRepository(userDao)
    private val somePet = Pet(name = "Pet1", imageRes = 1001)
    private val anotherPet = Pet(name = "Pet1", imageRes = 1002)

    @Before
    fun setup() {
        coEvery { userDao.insert(any()) } returns Unit
    }

    @Test
    fun `createUser() should add a User, when no User exists`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow { emit(null) }
            val user = User(pet = somePet)

            // Act
            val createdUser = userRepository.createUser(user)

            // Assert
            coVerify { userDao.insert(user) }
            assertThat(createdUser).isEqualTo(user)
        }
    }


    @Test()
    fun `createUser() should throw an IllegalStateException, when a User already exists`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow {
                emit(User(pet = somePet))
            }
            val user = User(pet = anotherPet)

            // Act
            val exception = runCatching {
                userRepository.createUser(user)
            }.exceptionOrNull()

            // Assert
            assertThat(exception).isInstanceOf(UserExistsException::class.java)
        }
    }

    @Test()
    fun `createUser() should throw IllegalArgumentException, when invalid UUID format`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow { emit(null) }
            val user1 = User(uuid = "invalid-uid", pet = somePet)

            // Act
            val exception = runCatching {
                userRepository.createUser(user1)
            }.exceptionOrNull()
            assertThat(exception).isInstanceOf(InvalidUUIdException::class.java)
        }
    }

    @Test()
    fun `deleteUser() should remove the User`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow {
                emit(User(pet = somePet))
            }
            coEvery { userDao.deleteAll() } returns Unit

            // Act
            userRepository.deleteUser()

            // Assert
            coVerify { userDao.deleteAll() }
        }
    }
}
