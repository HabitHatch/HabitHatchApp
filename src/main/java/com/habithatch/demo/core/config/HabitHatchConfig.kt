package com.habithatch.demo.core.config

import androidx.compose.ui.text.font.FontFamily
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.Pet

/**
 * The main application configuration.
 */
interface HabitHatchConfig :
    GoalStatusProvider,
    GoalPriorityProvider {
    val pets: List<Pet>
    val numberExampleGoals: Int
    val signUpNavigationItem: Screen
    val homeNavigationItem: Screen
    val settingsNavigationItem: Screen
    val navigationItems: List<Screen>
    val topRightNavItem: Screen

    val displayFontFamily: FontFamily

    val bodyFontFamily: FontFamily

    val defaultGoalQuery: GoalQuery
}
