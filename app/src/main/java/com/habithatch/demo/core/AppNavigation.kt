package com.habithatch.demo.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.common.LoadingScreen
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.home.HomeViewModel
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.signup.InitialLoginScreen
import com.habithatch.demo.features.signup.SignUpStatus
import com.habithatch.demo.features.signup.SignupViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Settings : Screen("settings")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val signupViewModel: SignupViewModel = hiltViewModel()
    val isSignedUp by signupViewModel.isSignedUp.collectAsStateWithLifecycle()

    Log.d("AppNavigation", "isSignedUp: $isSignedUp")
    when (isSignedUp) {
        SignUpStatus.SIGNED_UP -> {
            NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(Screen.Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
        SignUpStatus.NOT_SIGNED_UP -> {
            InitialLoginScreen()
        }

        SignUpStatus.LOADING -> {
            LoadingScreen()
        }
    }
}