package com.habithatch.demo.core.navigation

data class NavigationItem(
    val screen: Screen,
    val iconResourceId: Int,
    val enabled: Boolean = true
) {
    companion object {
        fun findNavigationItemByRoute(
            route: String?,
            navigationItems: List<NavigationItem>
        ): NavigationItem? {
            val screen = Screen.fromRoute(route)
            return navigationItems.firstOrNull { it.screen == screen }
        }
    }
}
