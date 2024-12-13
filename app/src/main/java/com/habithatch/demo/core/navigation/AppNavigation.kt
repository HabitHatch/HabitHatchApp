package com.habithatch.demo.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.util.Log
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.common.ui.LoadingScreen
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.signup.InitialLoginScreen
import com.habithatch.demo.features.signup.SignUpState
import com.habithatch.demo.features.signup.SignupViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val signupViewModel: SignupViewModel = hiltViewModel()
    val isSignedUp by signupViewModel.isSignedUp.collectAsStateWithLifecycle()

    Log.d("AppNavigation", "isSignedUp: $isSignedUp")
    when (isSignedUp) {
        SignUpState.SIGNED_UP -> {
            NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
            ) {
                composable(Screen.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(Screen.Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }

        SignUpState.NOT_SIGNED_UP -> {
            InitialLoginScreen()
        }

        SignUpState.LOADING -> {
            LoadingScreen()
        }
    }
}
