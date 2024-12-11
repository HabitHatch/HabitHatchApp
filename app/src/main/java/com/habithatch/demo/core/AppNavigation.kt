package com.habithatch.demo.core

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.common.LoadingScreen
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.home.HomeViewModel
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.settings.SettingsViewModel
import com.habithatch.demo.features.signup.InitialLoginScreen
import com.habithatch.demo.features.signup.InitialLoginViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Settings : Screen("settings")
}

@Composable
fun AppNavigation(
    settingsViewModel: SettingsViewModel,
    initialLoginViewModel: InitialLoginViewModel,
    homeViewModel: HomeViewModel
) {
    val navController = rememberNavController()
    val isSignedUp by initialLoginViewModel.isSignedUp.collectAsState()
    if (isSignedUp == null) {
        LoadingScreen()
    } else if (isSignedUp == false) {
        InitialLoginScreen(
            viewModel = initialLoginViewModel
        )
    } else {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController = navController, viewModel = homeViewModel)
            }
            composable(Screen.Settings.route) {
                SettingsScreen(navController = navController, settingsViewModel = settingsViewModel)
            }
        }
    }
}