package com.habithatch.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.habithatch.demo.config.AppConfiguration
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.db.DatabaseProvider
import com.habithatch.demo.repositories.PetRepository
import com.habithatch.demo.repositories.UserRepository
import com.habithatch.demo.viewModels.InitialLoginViewModel
import com.habithatch.demo.viewModels.SettingsViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    private lateinit var userRepository: UserRepository
    private lateinit var petRepository: PetRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database: AppDatabase by lazy { DatabaseProvider.getDatabase(this) }

        val userDao = database.userDao()
        userRepository = UserRepository(userDao)

        petRepository = PetRepository(AppConfiguration.pets)

        setContent {
            HabitHatchAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavigation(
                        initialLoginViewModel = InitialLoginViewModel(userRepository, petRepository),
                        settingsViewModel = SettingsViewModel(userRepository)
                    )
                }
            }
        }
    }
}