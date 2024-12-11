package com.habithatch.demo.viewModels

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import com.habithatch.demo.repositories.PetRepository
import com.habithatch.demo.repositories.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class InitialLoginViewModelTest {
    private val userRepository = mockk<UserRepository>()
    private val petRepository = mockk<PetRepository>()

    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { petRepository.getAll() } returns emptyList()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `isSignedUp() should be true, when user exists`() {
        runTest {
            // Arrange
            coEvery { userRepository.getUser() } returns User(pet = Pet(name = "Dog", imageRes = -1))

            // Act
            val viewModel = InitialLoginViewModel(userRepository, petRepository)
            delay(10)

            // Assert
            assertThat(viewModel.isSignedUp.value).isTrue()
        }
    }

    @Test
    fun `isSignedUp() should be false, when no user exists`() {
        runTest {
            // Arrange
            coEvery { userRepository.getUser() } returns null

            // Act
            val viewModel = InitialLoginViewModel(userRepository, petRepository)
            delay(10)

            // Assert
            assertThat(viewModel.isSignedUp.value).isFalse()
        }
    }

    @Test
    fun `signUpUser(), should insert a user into the database`() {
        runTest {
            // Arrange
            val pet = Pet(name = "Dog", imageRes = -1)
            coEvery { userRepository.getUser() } returns null
            coEvery { userRepository.createUser(any()) } answers { firstArg() }
            // Act
            val viewModel = InitialLoginViewModel(userRepository, petRepository)
            viewModel.signUpUser(pet)
            delay(10)

            // Assert
            coVerify { userRepository.createUser(match { it.pet == pet }) }
        }
    }
}
