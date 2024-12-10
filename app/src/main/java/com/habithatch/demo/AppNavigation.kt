package com.habithatch.demo

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.screens.HomeScreen
import com.habithatch.demo.screens.InitialLoginScreen
import com.habithatch.demo.screens.LoadingScreen
import com.habithatch.demo.screens.SettingsScreen
import com.habithatch.demo.viewModels.InitialLoginViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


sealed class Screen(val route: String, val composable: (@Composable (NavHostController) -> Unit)? = null) {
    fun getComposable() {
        this.composable
    }

    object InitialLogin : Screen("initialLogin")
    object Home : Screen("home", @Composable { HomeScreen(it) })
    object Settings : Screen("settings", @Composable { SettingsScreen(it) })
}

@Composable
fun AppNavigation(initialLoginViewModel: InitialLoginViewModel) {
    val navController = rememberNavController()
    val isSignedUp by initialLoginViewModel.isSignedUp.collectAsState()

    if (isSignedUp == null) {
        LoadingScreen()
    } else {
        val startDestination = if (isSignedUp == true) {
            Screen.Home.route
        } else {
            Screen.InitialLogin.route
        }

        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(Screen.InitialLogin.route) {
                InitialLoginScreen(
                    navController = navController,
                    onSignUp = { pet ->
                        initialLoginViewModel.signUpUser(pet)
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.InitialLogin.route) { inclusive = true }
                        }
                    }
                )
            }
            listOf(Screen.Home, Screen.Settings).forEach { screen ->
                composable(screen.route) {
                    screen.composable?.let { it1 -> it1(navController) }
                }
            }
        }
    }
}