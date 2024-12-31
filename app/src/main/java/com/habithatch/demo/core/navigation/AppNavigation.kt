package com.habithatch.demo.core.navigation

import BottomNavBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.features.ai.AIScreen
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.signup.SignUpState
import com.habithatch.demo.features.signup.SignupScreen
import com.habithatch.demo.features.signup.SignupViewModel
import com.habithatch.demo.ui.navigation.TopNavBar

/**
 * The main application navigation.
 * @param config The application configuration.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AppNavigation(
    config: HabitHatchConfig,
) {
    val navController = rememberNavController()
    val signupViewModel: SignupViewModel = hiltViewModel()
    val signUpState by signupViewModel.signUpState.collectAsStateWithLifecycle()

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

    val topNavBar = @Composable {
        TopNavBar(
            title = config.settingsNavigationItem.title,
            rightNavItem = config.topRightNavItem,
            onRightNavItemClicked = { navController.navigate(config.topRightNavItem.route) },
            leftNavItem = config.topLeftNavItem,
            onLeftNavItemClicked = { navController.navigate(config.topLeftNavItem.route) },
        )
    }

    val bottomNavBar = @Composable {
        val currentRoute = navController.currentDestination?.route
        val activeNavigationItem = config.navigationItems.firstOrNull { it.route == currentRoute }
        check(activeNavigationItem != null) {
            "Current route $currentRoute is not in the list of navigation items"
        }
        BottomNavBar(
            onNavigationItemClicked = { navController.navigate(it.route) },
            activeNavScreen = activeNavigationItem,
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
                topNavBar = topNavBar,
                bottomNavBar = bottomNavBar,
            )
        }
        composable(config.settingsNavigationItem.route) {
            SettingsScreen(
                topNavBar = topNavBar,
                bottomNavBar = bottomNavBar,
            )
        }
        composable(config.aiNavItem.route) {
            AIScreen(
                topNavBar = topNavBar,
                bottomNavBar = bottomNavBar,
            )
        }
    }
}
