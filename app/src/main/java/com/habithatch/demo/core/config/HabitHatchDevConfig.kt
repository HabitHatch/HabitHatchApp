package com.habithatch.demo.core.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.data.entities.Pet

object HabitHatchDevConfig : HabitHatchConfig {
    override val pets = listOf(
            Pet(name = "Cat", imageRes = R.mipmap.pet_cat),
            Pet(name = "Fox", imageRes = R.mipmap.pet_fox),
            Pet(name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
            Pet(name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear)
    )
    override val navigationItems = listOf(
        NavigationItem(Screen.Home, Icons.Default.Home, true),
        NavigationItem(Screen.Settings, Icons.Default.Settings, true)
    )
}