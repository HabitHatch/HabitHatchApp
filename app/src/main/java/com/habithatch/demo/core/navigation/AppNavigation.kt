package com.habithatch.demo.core.navigation

import BottomNavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.signup.SignUpState
import com.habithatch.demo.features.signup.SignupScreen
import com.habithatch.demo.features.signup.SignupViewModel
import com.habithatch.demo.ui.navigation.TopAppInformationBar

@Suppress("ktlint:standard:function-naming")
@Composable
fun AppNavigation(
    config: HabitHatchConfig,
) {
    val navController = rememberNavController()
    val signupViewModel: SignupViewModel = hiltViewModel()
    val signUpState by signupViewModel.signUpState.collectAsStateWithLifecycle()

    val currentRoute = navController.currentDestination?.route
    val activeNavigationItem = config.navigationItems.first { it.route == currentRoute }
    LaunchedEffect(signUpState) {
        when (signUpState) {
            SignUpState.NOT_SIGNED_UP -> {
                navController.navigate(config.signUpNavigationItem.route) {
                    popUpTo(0)
                }
            }

            SignUpState.SIGNED_UP -> navController.navigate(config.homeNavigationItem.route)
            else -> Unit // No navigation for LOADING, should load in  less than 100ms
        }
    }

    val bottomNavigationBar = @Composable {
        BottomNavigationBar(
            onNavigationItemClicked = {
                navController.navigate(it.route)
            },
            activeNavigationItem = activeNavigationItem,
            navigationItems = config.navigationItems,
        )
    }

    NavHost(
        navController = navController,
        startDestination = config.homeNavigationItem.route,
    ) {
        composable(config.signUpNavigationItem.route) {
            SignupScreen()
        }
        composable(config.homeNavigationItem.route) {
            HomeScreen(
                topAppInformationBar = {
                    TopAppInformationBar(
                        title = activeNavigationItem.title,
                        primaryNavigationItem = config.primaryNavigationItem,
                        onPrimaryNavigationItemClick = {
                            navController.navigate(config.primaryNavigationItem.route)
                        },
                    )
                },
                bottomNavigationBar = bottomNavigationBar,
            )
        }
        composable(config.settingsNavigationItem.route) {
            SettingsScreen(
                topAppInformationBar = {
                    TopAppInformationBar(
                        title = activeNavigationItem.title,
                        primaryNavigationItem = config.primaryNavigationItem,
                        onPrimaryNavigationItemClick = {
                            navController.navigate(config.primaryNavigationItem.route)
                        },
                    )
                },
                bottomNavigationBar = bottomNavigationBar,
            )
        }
    }
}
