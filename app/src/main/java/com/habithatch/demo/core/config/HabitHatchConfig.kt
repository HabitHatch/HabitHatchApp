package com.habithatch.demo.core.config

import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalFilter

interface HabitHatchConfig {
    val pets: List<Pet>
    val navigationItems: List<NavigationItem>
    val accountItem: NavigationItem
    val defaultFilter: GoalFilter
}