package com.habithatch.demo.core.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.Goal
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
                    comparator = compareBy { it.priority.importance },
                    isAscending = false
            )
    )

    override val statuses = listOf(
            GoalStatus(
                    id = "IN_PROGRESS",
                    label = "In Progress",
                    stepNumber = 1
            ),
            GoalStatus(
                    id = "DONE",
                    label = "Done",
                    stepNumber = 2
            )
    )
    override val defaultStatus = getStatusById("IN_PROGRESS")

    override val priorities = listOf(
            GoalPriority(
                    id = "NORMAL",
                    label = "Normal",
                    importance = 10,
                    iconResourceId = R.drawable.vuesax_bookmark,
                    getColor = @Composable { MaterialTheme.colorScheme.secondary }
            ),
            GoalPriority(
                    id = "HIGH",
                    label = "High",
                    importance = 20,
                    iconResourceId = R.drawable.vuesax_crown,
                    getColor = @Composable { MaterialTheme.colorScheme.primary }
            )
    )
    override val defaultPriority = priorities.first()

    override val exampleGoals = listOf(
            Goal(
                    title = "Drink water",
                    priority = getPriorityById("NORMAL"),
                    status = getStatusById("IN_PROGRESS")
            ),
            Goal(
                    title = "Read a book",
                    priority = getPriorityById("HIGH"),
                    status = getStatusById("IN_PROGRESS")
            ),
            Goal(
                    title = "Exercise",
                    priority = getPriorityById("NORMAL"),
                    status = getStatusById("DONE")
            )
    )
}