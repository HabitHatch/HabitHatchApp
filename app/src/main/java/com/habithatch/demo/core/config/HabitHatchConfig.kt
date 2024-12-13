package com.habithatch.demo.core.config

import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.data.entities.Pet

interface HabitHatchConfig {
    val pets: List<Pet>
    val navigationItems: List<NavigationItem>
}