package com.habithatch.demo.core.config

import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.util.GoalSortOption
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery

interface HabitHatchConfig: GoalStatusProvider, GoalPriorityProvider {
    val pets: List<Pet>
    val exampleGoals: List<GoalModel>
    val navigationItems: List<NavigationItem>
    val primaryNavigationItem: NavigationItem
    val sortOptions: List<GoalSortOption>
    fun getDefaultGoalQuery(): GoalQuery
}