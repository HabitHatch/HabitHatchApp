package com.habithatch.demo.core.config

import androidx.compose.ui.text.font.FontFamily
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.HabitModel

/**
 * The main application configuration.
 */
interface HabitHatchConfig :
    HabitStatusProvider,
    HabitPriorityProvider {
    val pets: List<Pet>
    val exampleHabits: Collection<HabitModel>
    val signUpNavigationItem: Screen
    val homeNavigationItem: Screen
    val settingsNavigationItem: Screen
    val navigationItems: List<Screen>
    val topRightNavItem: Screen
    val topLeftNavItem: Screen
    val aiNavItem: Screen

    val displayFontFamily: FontFamily

    val bodyFontFamily: FontFamily

    val defaultHabitQuery: HabitQuery
}
