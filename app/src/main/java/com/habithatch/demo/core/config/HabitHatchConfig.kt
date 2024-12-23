package com.habithatch.demo.core.config

import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel

interface HabitHatchConfig :
    GoalStatusProvider,
    GoalPriorityProvider {
    val pets: List<Pet>
    val exampleGoals: List<GoalModel>
    val navigationItems: List<NavigationItem>
    val primaryNavigationItem: NavigationItem

    fun getDefaultGoalQuery(): GoalQuery
}
