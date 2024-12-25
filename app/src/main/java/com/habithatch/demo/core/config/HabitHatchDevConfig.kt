package com.habithatch.demo.core.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.query.GoalSortOption
import com.habithatch.demo.core.util.createDate
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel

object HabitHatchDevConfig : HabitHatchConfig {
    override val pets =
        listOf(
            Pet(name = "Cat", imageRes = R.mipmap.pet_cat),
            Pet(name = "Fox", imageRes = R.mipmap.pet_fox),
            Pet(name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
            Pet(name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear),
        )

    override val signUpNavigationItem = Screen("sign_up", R.drawable.vuesax_profile_circle)
    override val homeNavigationItem = Screen("home", R.drawable.vuesax_home_2)
    override val settingsNavigationItem = Screen("settings", R.drawable.vuesax_menu)
    override val navigationItems =
        listOf(
            homeNavigationItem,
            Screen("goals", R.drawable.vuesax_flag, enabled = false),
            Screen("friends", R.drawable.vuesax_profile_2user, enabled = false),
            Screen("pet", R.drawable.vuesax_pet, enabled = false),
            settingsNavigationItem,
        )

    override val primaryNavigationItem = settingsNavigationItem

    private val inProgressStatus =
        GoalModel.Status(
            label = "In Progress",
            stepNumber = 1,
            isDone = false,
        )

    private val doneStatus =
        GoalModel.Status(
            label = "Done",
            stepNumber = 2,
            isDone = true,
        )
    override val statuses = listOf(inProgressStatus, doneStatus)

    override val defaultStatus = inProgressStatus

    private val normalPriority =
        GoalModel.Priority(
            label = "Normal",
            importance = 10,
            iconResourceId = R.drawable.vuesax_bookmark,
            getColor = @Composable { MaterialTheme.colorScheme.tertiary },
        )

    private val highPriority =
        GoalModel.Priority(
            label = "High",
            importance = 20,
            iconResourceId = R.drawable.vuesax_crown,
            getColor = @Composable { MaterialTheme.colorScheme.error },
        )

    override val priorities = listOf(normalPriority, highPriority)

    override val defaultPriority = normalPriority
    override val exampleGoals =
        listOf(
            GoalModel(
                title = "Drink water",
                status = inProgressStatus,
                priority = normalPriority,
                createdAt = createDate(2024, 12, 4),
            ),
            GoalModel(
                title = "Read a book",
                status = inProgressStatus,
                priority = highPriority,
                createdAt = createDate(2024, 12, 8),
            ),
            GoalModel(
                title = "Learn Math",
                status = inProgressStatus,
                priority = normalPriority,
                createdAt = createDate(2024, 12, 9),
            ),
            GoalModel(
                title = "Learn Spanish",
                status = inProgressStatus,
                priority = highPriority,
                createdAt = createDate(2024, 12, 11),
            ),
            GoalModel(
                title = "Exercise",
                status = doneStatus,
                priority = normalPriority,
                createdAt = createDate(2024, 12, 1),
            ),
            GoalModel(
                title = "Meditate",
                status = doneStatus,
                priority = highPriority,
                createdAt = createDate(2024, 12, 2),
            ),
        )

    private val sortOptions =
        listOf(
            GoalSortOption(
                "Date",
                compareBy<GoalModel> { it.createdAt },
            ),
            GoalSortOption(
                "Priority",
                compareBy<GoalModel>
                    { it.priority.importance },
            ),
        )

    override fun getDefaultGoalQuery(): GoalQuery = defaultGoalQuery

    private val defaultGoalQuery: GoalQuery

    init {
        val goalFilter =
            GoalFilter
                .Builder
                .createMatchAllBuilder(this, this)
                .excludeStatus(doneStatus)
                .build()

        defaultGoalQuery =
            GoalQuery(
                filter = goalFilter,
                sortOptions = this.sortOptions,
                defaultComparator = compareBy<GoalModel> { it.title },
                priorityProvider = this,
                statusProvider = this,
            )
    }
}
