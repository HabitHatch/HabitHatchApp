package com.habithatch.demo.core.config

import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.data.entities.Pet

/**
 * The main application configuration.
 */
interface HabitHatchConfig :
    HabitStatusProvider,
    HabitPriorityProvider {
    val pets: List<Pet>
    val numberExampleHabits: Int
    val signUpNavItem: Screen
    val homeNavItem: Screen
    val settingsNavigationItem: Screen
    val navItems: List<Screen>
    val topRightNavItem: Screen

    val displayFontFamily: FontFamily

    val bodyFontFamily: FontFamily

    val defaultHabitQuery: HabitQuery

    @Throws(NoSuchElementException::class)
    fun getPetById(id: Int): Pet = pets.first { it.id == id }

    @Throws(NoSuchElementException::class)
    fun getActiveNavItem(navController: NavController): Screen {
        val currentRoute = navController.currentDestination?.route
        return this.navItems.first { it.route == currentRoute }
    }
}
