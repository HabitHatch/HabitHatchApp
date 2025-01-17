package com.habithatch.demo.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.util.navigateTo
import com.habithatch.demo.features.home.HomeScreen
import com.habithatch.demo.features.settings.SettingsScreen
import com.habithatch.demo.features.signup.SignUpState
import com.habithatch.demo.features.signup.SignupScreen
import com.habithatch.demo.features.signup.SignupViewModel
import com.habithatch.demo.ui.navigation.BottomNavBar
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
    val navController: NavHostController = rememberNavController()
    val signupViewModel: SignupViewModel = hiltViewModel()
    val signUpState by signupViewModel.signUpState.collectAsStateWithLifecycle()

    LaunchedEffect(signUpState) {
        when (signUpState) {
            SignUpState.NOT_SIGNED_UP -> {
                navController.navigate(config.signUpNavItem.route) {
                    popUpTo(0)
                }
            }

            SignUpState.SIGNED_UP -> navController.navigateTo(config.homeNavItem)
            else -> Unit // No navigation for LOADING, should load in  less than 100ms
        }
    }

    val topNavBar = @Composable {
        TopNavBar(
            title = stringResource(config.getActiveNavItem(navController).titleRes),
            rightNavItem = config.topRightNavItem,
            onRightNavItemClicked = { navController.navigateTo(config.topRightNavItem) },
        )
    }

    val bottomNavBar = @Composable {
        BottomNavBar(
            navigationItems = config.navItems,
            activeNavScreen = config.getActiveNavItem(navController),
            onNavigationItemClicked = { navController.navigateTo(it) },
        )
    }

    NavHost(
        navController = navController,
        startDestination = config.signUpNavItem.route,
    ) {
        composable(config.signUpNavItem.route) {
            SignupScreen()
        }
        composable(config.homeNavItem.route) {
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
    }
}
