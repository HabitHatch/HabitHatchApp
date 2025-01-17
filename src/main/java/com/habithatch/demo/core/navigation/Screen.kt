package com.habithatch.demo.core.navigation

/** Represents a screen in the app. Is used to generate the navigation graph. */
data class Screen(
    val route: String,
    val titleRes: Int,
    val iconResourceId: Int,
    val enabled: Boolean = true,
)
