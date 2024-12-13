package com.habithatch.demo.viewModels

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.repositories.UserRepository
import com.habithatch.demo.features.signup.SignUpState
import com.habithatch.demo.features.signup.SignupViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withTimeout
import org.junit.After
import org.junit.Before
import org.junit.Test

class SignupViewModelTest {
    private val userRepository = mockk<UserRepository>()
    private val appConfig = mockk<HabitHatchConfig>()

    private val testDispatcher = StandardTestDispatcher()
    private val someUser = User(pet = Pet(name = "Dog", imageRes = 1001))

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { appConfig.pets } returns emptyList()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `isSignedUp() should be SIGNED_UP, when user exists`() {
        runTest {
            // Arrange
            coEvery { userRepository.getUser() } returns flow {
                emit(someUser)
            }
            val viewModel = SignupViewModel(userRepository, appConfig)
            val signUpState = viewModel.isSignedUp
            val actualValues = mutableListOf<SignUpState>()
            // Act

            withTimeout(1000) {
                signUpState.take(2).collect {
                    actualValues.add(it)
                }
            }

            // Assert
            assertThat(actualValues)
                .containsExactly(SignUpState.LOADING, SignUpState.SIGNED_UP)
                .inOrder()
        }
    }

    @Test
    fun `isSignedUp() should be NOT_SIGNED_UP, when no user exists`() {
        runTest {
            // Arrange
            coEvery { userRepository.getUser() } returns flow { emit(null) }

            // Act
            val viewModel = SignupViewModel(userRepository, appConfig)
            delay(100)

            // Assert
            assertThat(viewModel.isSignedUp.value).isEqualTo(SignUpState.NOT_SIGNED_UP)
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
            val viewModel = SignupViewModel(userRepository, appConfig)
            viewModel.signUpUser(pet)
            delay(100)

            // Assert
            coVerify { userRepository.createUser(match { it.pet == pet }) }
        }
    }
}
