package com.habithatch.demo.viewModels

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import com.habithatch.demo.repositories.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class InitialLoginViewModelTest {

    private lateinit var database: AppDatabase
    private lateinit var userRepository: UserRepository
    private lateinit var viewModel: InitialLoginViewModel

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        val userDao = database.userDao()
        userRepository = UserRepository(userDao)
        viewModel = InitialLoginViewModel(userRepository)
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `isSignedUp() should be true, when user exists`() {
        runBlocking {
            // Arrange
            val user = User(petId = 1)

            // Act
            userRepository.createUser(user)
            val viewModel = InitialLoginViewModel(userRepository)

            // Assert
            assertThat(viewModel.isSignedUp.first()).isTrue()
        }
    }
    @Test
    fun `isSignedUp() should be false, when no user exists`() {
        runBlocking {
            // Arrange

            // Act
            val viewModel = InitialLoginViewModel(userRepository)

            // Assert
            assertThat(viewModel.isSignedUp.first()).isFalse()
        }
    }

    @Test
    fun `signUpUser(), should insert a user into the database`() {

        // Arrange
        val pet = Pet(id = 1, name = "Dog", imageRes = -1)

        // Act
        viewModel.signUpUser(pet)

        runBlocking {
            delay(100)
            // Assert
            val user = userRepository.getUser()
            assertThat(user).isNotNull()
        }
    }
}
