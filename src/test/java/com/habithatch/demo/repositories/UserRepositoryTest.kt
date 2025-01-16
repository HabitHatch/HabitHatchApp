package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.core.exceptions.InvalidUUIdException
import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.data.daos.UserDao
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.UserEntity
import com.habithatch.demo.data.mappers.UserMapper
import com.habithatch.demo.data.models.UserModel
import com.habithatch.demo.data.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import java.util.UUID
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {
    private val userDao = mockk<UserDao>()
    private val userMapper = mockk<UserMapper>()
    private val userRepository = UserRepository(userDao, userMapper)
    private val somePet = Pet(id = 1, name = "Pet1", coverImage = 1001)
    private val anotherPet = Pet(id = 2, name = "Pet1", coverImage = 1002)
    private val someUser = UserModel(uuid = UUID.randomUUID(), pet = somePet)
    private val someUserEntity = UserEntity(uuid = someUser.uuid, petId = somePet.id)

    @Before
    fun setup() {
        coEvery { userDao.insert(any()) } returns Unit
    }

    @Test
    fun `createUser() should add a User, when no User exists`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns flow { emit(null) }
            // Act
            userRepository.createUser(someUser)

            // Assert
            coVerify { userDao.insert(someUserEntity) }
        }
    }

    @Test()
    fun `createUser() should throw an IllegalStateException, when a User already exists`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns
                    flow {
                        emit(someUserEntity)
                    }

            // Act
            val exception =
                runCatching {
                    userRepository.createUser(someUser)
                }.exceptionOrNull()

            // Assert
            assertThat(exception).isInstanceOf(UserExistsException::class.java)
        }
    }

    @Test()
    fun `deleteUser() should remove the User`() {
        runBlocking {
            // Arrange
            coEvery { userDao.getUser() } returns
                flow {
                    emit(someUserEntity)
                }
            coEvery { userDao.deleteAll() } returns Unit

            // Act
            userRepository.deleteUser()

            // Assert
            coVerify { userDao.deleteAll() }
        }
    }
}
