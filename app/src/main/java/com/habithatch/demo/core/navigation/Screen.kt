package com.habithatch.demo.core.navigation

enum class Screen(val route: String, val title: String) {
    SIGNUP("signup", "Sign Up"),
    HOME("home", "Home"),
    GOALS("goals", "Goals"),
    FRIENDS("friends", "Friends"),
    PET("pet", "Pet"),
    SETTINGS("settings", "Settings");

    companion object {
        fun fromRoute(route: String?): Screen? {
            return Screen.entries.firstOrNull {
                it.route == route
            }
        }
    }
}
