package com.habithatch.demo.core

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.habithatch.demo.core.config.AppConfiguration
import com.habithatch.demo.data.db.AppDatabase
import com.habithatch.demo.data.db.DatabaseProvider
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.PetRepository
import com.habithatch.demo.data.repositories.UserRepository
import com.habithatch.demo.features.home.HomeViewModel
import com.habithatch.demo.features.settings.SettingsViewModel
import com.habithatch.demo.features.signup.InitialLoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    private lateinit var userRepository: UserRepository
    private lateinit var petRepository: PetRepository
    private lateinit var goalRepository: GoalRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        switchActivityToMeetTheCustomerRequirement()

        val database: AppDatabase by lazy { DatabaseProvider.getDatabase(this) }

        userRepository = UserRepository(database.userDao())
        petRepository = PetRepository(AppConfiguration.pets)
        goalRepository = GoalRepository(database.goalDao())

        seedDatabase()

        setContent {
            HabitHatchAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavigation(
                        initialLoginViewModel = InitialLoginViewModel(userRepository, petRepository),
                        settingsViewModel = SettingsViewModel(userRepository),
                        homeViewModel = HomeViewModel(userRepository, goalRepository)
                    )
                }
            }
        }
    }

    private fun seedDatabase() {
        val goals = listOf(
            Goal(id = 1, title = "Drink water", isDone = false),
            Goal(id = 2, title = "Read a book", isDone = false),
            Goal(id = 3, title = "Exercise", isDone = true)
        )

        CoroutineScope(Dispatchers.IO).launch {
            val existingGoals = goalRepository.getAll().firstOrNull()
            if (existingGoals.isNullOrEmpty()) {
                goals.forEach { goalRepository.insert(it) }
            }
        }
    }

    private fun switchActivityToMeetTheCustomerRequirement() {
        val intent = Intent(this, ImmediatelyFinishingActivity::class.java)
        startActivity(intent)
    }
}