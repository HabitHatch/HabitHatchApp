package com.habithatch.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.screens.HomeScreen
import com.habithatch.demo.screens.InitialLoginScreen
import com.habithatch.demo.screens.SettingsScreen

sealed class Screen(val route: String, val composable: @Composable (NavHostController) -> Unit) {
    object InitialLogin : Screen("initialLogin", @Composable { navController -> InitialLoginScreen(navController) })
    object Home : Screen("home", @Composable { navController -> HomeScreen(navController) })
    object Settings : Screen("settings", @Composable { navController -> SettingsScreen(navController) })
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.InitialLogin.route
    ) {
        listOf(Screen.InitialLogin, Screen.Home, Screen.Settings).forEach { screen ->
            composable(screen.route) {
                screen.composable(navController)
            }
        }
    }
}