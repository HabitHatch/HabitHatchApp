package com.habithatch.demo.core.config

import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.core.util.SortDirection
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalFilterAttributes
import com.habithatch.demo.data.models.GoalQuery

object HabitHatchDevConfig : HabitHatchConfig {
    override val pets = listOf(
            Pet(name = "Cat", imageRes = R.mipmap.pet_cat),
            Pet(name = "Fox", imageRes = R.mipmap.pet_fox),
            Pet(name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
            Pet(name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear)
    )
    override val navigationItems = listOf(
            NavigationItem(Screen.HOME, R.drawable.vuesax_home_2, enabled = true),
            NavigationItem(Screen.GOALS, R.drawable.vuesax_flag, enabled = false),
            NavigationItem(Screen.FRIENDS, R.drawable.vuesax_profile_2user, enabled = false),
            NavigationItem(Screen.PET, R.drawable.vuesax_pet, enabled = false),
            NavigationItem(Screen.SETTINGS, R.drawable.vuesax_menu, enabled = true),
    )

    override val accountItem =
        NavigationItem(Screen.SETTINGS, R.drawable.vuesax_profile_circle, enabled = true)
    override val defaultGoalQuery = GoalQuery(
            filterConfig = GoalFilterAttributes.createMatchAllInProgressFilter(),
            sortConfig = SortConfig(
                    attribute = Goal::priority,
                    comparator = compareBy { it.priority.importance },
                    direction = SortDirection.DESC
            )
    )
}