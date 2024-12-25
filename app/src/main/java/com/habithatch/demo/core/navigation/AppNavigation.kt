package com.habithatch.demo.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.signup.SignUpState
import com.habithatch.demo.features.signup.SignupScreen
import com.habithatch.demo.features.signup.SignupViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val signupViewModel: SignupViewModel = hiltViewModel()
    val signUpState by signupViewModel.signUpState.collectAsStateWithLifecycle()

    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val screen = Screen.fromRoute(currentRoute)
    LaunchedEffect(signUpState) {
        when (signUpState) {
            SignUpState.NOT_SIGNED_UP -> {
                navController.navigate(Screen.SIGNUP.route) {
                    popUpTo(0) { inclusive = true }
                }
            }
            SignUpState.SIGNED_UP -> {
                navController.navigate(Screen.HOME.route)
            }
            else -> Unit // No navigation for LOADING, should load less than 100ms
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.HOME.route,
    ) {
        composable(Screen.SIGNUP.route) {
            SignupScreen()
        }
        composable(Screen.HOME.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.SETTINGS.route) {
            SettingsScreen(navController = navController)
        }
    }
}
