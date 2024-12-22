package com.habithatch.demo.core.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.habithatch.demo.R.drawable.*
import com.habithatch.demo.R.mipmap.*
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.util.GoalSortOption
import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery

object HabitHatchDevConfig : HabitHatchConfig {
    override val pets = listOf(
            Pet(name = "Cat", imageRes = pet_cat),
            Pet(name = "Fox", imageRes = pet_fox),
            Pet(name = "Rabbit", imageRes = pet_rabbit),
            Pet(name = "Ice Bear", imageRes = pet_ice_bear)
    )
    override val navigationItems = listOf(
            NavigationItem(Screen.HOME, vuesax_home_2, enabled = true),
            NavigationItem(Screen.GOALS, vuesax_flag, enabled = false),
            NavigationItem(Screen.FRIENDS, vuesax_profile_2user, enabled = false),
            NavigationItem(Screen.PET, vuesax_pet, enabled = false),
            NavigationItem(Screen.SETTINGS, vuesax_menu, enabled = true),
    )

    private val accountItem =
        NavigationItem(Screen.SETTINGS, vuesax_profile_circle, enabled = true)

    override val primaryNavigationItem = accountItem

    private val inProgressStatus = GoalModel.Status(
            label = "In Progress",
            stepNumber = 1,
            isDone = false
    )

    private val doneStatus = GoalModel.Status(
            label = "Done",
            stepNumber = 2,
            isDone = true
    )
    override val statuses = listOf(inProgressStatus, doneStatus)

    override val defaultStatus = inProgressStatus

    private val normalPriority = GoalModel.Priority(
            label = "Normal",
            importance = 10,
            iconResourceId = vuesax_bookmark,
            getColor = @Composable { MaterialTheme.colorScheme.secondary }
    )

    private val highPriority = GoalModel.Priority(
            label = "High",
            importance = 20,
            iconResourceId = vuesax_crown,
            getColor = @Composable { MaterialTheme.colorScheme.primary }
    )

    override val priorities = listOf(normalPriority, highPriority)

    override val defaultPriority = normalPriority

    override val exampleGoals = listOf(
            GoalModel(id = 1, "Drink water", inProgressStatus, normalPriority),
            GoalModel(id = 2, "Read a book", inProgressStatus, highPriority),
            GoalModel(id = 3, "Exercise", doneStatus, normalPriority),
            GoalModel(id = 4, "Meditate", doneStatus, highPriority),
    )

    override val sortOptions = listOf(
            GoalSortOption(
                    "Title",
                    compareBy<GoalModel> { it.title }
            ),
             GoalSortOption(
                    "Priority",
                    compareBy<GoalModel> { it.priority.importance }
            ),

    )

    override fun getDefaultGoalQuery(): GoalQuery {
        return defaultGoalQuery
    }

    private val defaultGoalQuery: GoalQuery

    init {
        val goalFilter = GoalFilter.Builder(this, this)
                .createMatchAll()
                .excludeStatus(doneStatus)
                .build()
        defaultGoalQuery = GoalQuery(
                filter = goalFilter,
                sortOptions = this.sortOptions,
                defaultSortConfig = SortConfig(compareBy { it.id }, false)
        )
    }
}