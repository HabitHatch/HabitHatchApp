package com.habithatch.demo.core.config

import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalFilter

object HabitHatchDevConfig : HabitHatchConfig {
    override val pets = listOf(
            Pet(name = "Cat", imageRes = R.mipmap.pet_cat),
            Pet(name = "Fox", imageRes = R.mipmap.pet_fox),
            Pet(name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
            Pet(name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear)
    )
    override val navigationItems = listOf(
            NavigationItem(Screen.HOME, R.drawable.vuesax_home_2, true),
            NavigationItem(Screen.GOALS, R.drawable.vuesax_flag, false),
            NavigationItem(Screen.FRIENDS, R.drawable.vuesax_profile_2user, false),
            NavigationItem(Screen.PET, R.drawable.vuesax_pet, false),
            NavigationItem(Screen.SETTINGS, R.drawable.vuesax_menu, true),
    )

    override val accountItem =
        NavigationItem(Screen.SETTINGS, R.drawable.vuesax_profile_circle, true)

    override val defaultFilter = GoalFilter.createMatchAllFilter().copy(
            goalStatusVisibleMap = GoalFilter.createMatchAllFilter().goalStatusVisibleMap.apply {
                put(GoalStatus.DONE, false)
                put(GoalStatus.UNDONE, true)
            }
    )
}