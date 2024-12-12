package com.habithatch.demo.viewModels

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.repositories.PetRepository
import com.habithatch.demo.data.repositories.UserRepository
import com.habithatch.demo.features.signup.SignUpStatus
import com.habithatch.demo.features.signup.SignupViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
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
            coEvery { userRepository.getUser() } returns flow {
                emit(User(pet = Pet(name = "Dog", imageRes = -1)))
            }

            // Act
            val viewModel = SignupViewModel(userRepository, petRepository)
            delay(10)

            // Assert
            assertThat(viewModel.isSignedUp.value).isEqualTo(SignUpStatus.SIGNED_UP)
        }
    }

    @Test
    fun `isSignedUp() should be false, when no user exists`() {
        runTest {
            // Arrange
            coEvery { userRepository.getUser() } returns flow { emit(null) }

            // Act
            val viewModel = SignupViewModel(userRepository, petRepository)
            delay(10)

            // Assert
            assertThat(viewModel.isSignedUp.value).isEqualTo(SignUpStatus.NOT_SIGNED_UP)
        }
    }

    @Test
    fun `signUpUser(), should insert a user into the database`() {
        runTest {
            // Arrange
            val pet = Pet(name = "Dog", imageRes = -1)
            coEvery { userRepository.getUser() } returns flow { emit(null) }
            coEvery { userRepository.createUser(any()) } answers { firstArg() }
            // Act
            val viewModel = SignupViewModel(userRepository, petRepository)
            viewModel.signUpUser(pet)
            delay(10)

            // Assert
            coVerify { userRepository.createUser(match { it.pet == pet }) }
        }
    }
}
