package com.habithatch.demo.core.navigation

import java.util.Locale

/**
 * Represents a screen in the app. Is used to generate the navigation graph.
*/
data class Screen(
    val route: String,
    val iconResourceId: Int,
    val enabled: Boolean = true,
) {
    val title: String
        get() =
            route.lowercase().replace('_', ' ').replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
}
