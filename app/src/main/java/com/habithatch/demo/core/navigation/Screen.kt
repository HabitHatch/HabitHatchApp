package com.habithatch.demo.core.navigation

sealed class Screen(
    val route: String,
    val label: String,
) {
    object Home : Screen(
            route = "home",
            label = "Home",
    )

    object Settings : Screen(
            route = "settings",
            label = "Settings",
    )

    companion object {
        fun fromRoute(route: String?): Screen? {
            return when (route) {
                Home.route -> Home
                Settings.route -> Settings
                else -> null
            }
        }
    }
}

fun Screen.getNavigationItem(navigationItems: List<NavigationItem>): NavigationItem?{
    return navigationItems.filter { this.route == it.screen.route }.firstOrNull()
}
