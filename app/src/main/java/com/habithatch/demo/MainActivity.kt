package com.habithatch.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.db.DatabaseProvider
import com.habithatch.demo.viewModels.InitialLoginViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    private lateinit var userDao: UserDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database: AppDatabase by lazy { DatabaseProvider.getDatabase(this) }
        userDao = database.userDao()

        setContent {
            HabitHatchAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AppNavigation(initialLoginViewModel = InitialLoginViewModel(userDao))
                }
            }
        }
    }
}