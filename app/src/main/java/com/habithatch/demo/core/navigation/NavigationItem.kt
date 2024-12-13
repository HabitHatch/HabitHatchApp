package com.habithatch.demo.core.navigation

data class NavigationItem(
    val screen: Screen,
    val iconResourceId: Int,
    val enabled: Boolean = true
)
