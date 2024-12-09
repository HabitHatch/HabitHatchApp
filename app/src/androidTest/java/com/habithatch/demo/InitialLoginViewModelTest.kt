package com.habithatch.demo

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import com.habithatch.demo.viewModels.InitialLoginViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InitialLoginViewModelInstrumentedTest {

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao
    private lateinit var viewModel: InitialLoginViewModel

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        userDao = database.userDao()
        viewModel = InitialLoginViewModel(userDao)
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `isSignedUp should be true when user exists`() = runBlocking {
        // Arrange
        val user = User(id = 1, pet = Pet("Cat", 123))

        // Act
        userDao.insertOrUpdateUser(user)

        // Assert
        assertThat(viewModel.isSignedUp.first()).isTrue()
    }

    @Test
    fun `signUpUser inserts user into the database`() = runBlocking {
        // Arrange
        val pet = Pet(name = "Dog", imageRes = 456)

        // Act
        viewModel.signUpUser(pet)

        // Assert
        val user = userDao.getUser()
        assertThat(user).isNotNull()
        assertThat(user?.pet?.name).isEqualTo("Dog")
        assertThat(user?.pet?.imageRes).isEqualTo(456)
    }
}
