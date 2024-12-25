package com.habithatch.demo.core.navigation

import java.util.Locale

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
