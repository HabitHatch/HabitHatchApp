package com.habithatch.demo.core.config

import androidx.compose.ui.text.font.FontFamily
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel

interface HabitHatchConfig :
    GoalStatusProvider,
    GoalPriorityProvider {
    val pets: List<Pet>
    val exampleGoals: Set<GoalModel>
    val signUpNavigationItem: Screen
    val homeNavigationItem: Screen
    val settingsNavigationItem: Screen
    val navigationItems: List<Screen>
    val primaryNavigationItem: Screen

    val displayFontFamily: FontFamily

    val bodyFontFamily: FontFamily

    fun getDefaultGoalQuery(): GoalQuery
}
