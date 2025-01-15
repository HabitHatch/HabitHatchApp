package com.habithatch.demo.core.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.query.GoalSortOption
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel
import javax.inject.Inject

/**
 * The main application configuration for the development environment.
 */
class HabitHatchDevConfig
    @Inject
    constructor(
        googleFontProvider: GoogleFont.Provider,
    ) : HabitHatchConfig {
        override val pets =
            listOf(
                Pet(id = 1, name = "Cat", imageRes = R.mipmap.pet_cat),
                Pet(id = 2, name = "Fox", imageRes = R.mipmap.pet_fox),
                Pet(id = 3, name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
                Pet(id = 4, name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear),
            )

        override val signUpNavigationItem = Screen("sign_up", R.drawable.vuesax_profile_circle)
        override val homeNavigationItem = Screen("home", R.drawable.vuesax_home_2)
        override val settingsNavigationItem = Screen("settings", R.drawable.vuesax_profile_circle)

        override val navigationItems =
            listOf(
                homeNavigationItem,
                Screen("goals", R.drawable.vuesax_flag, enabled = false),
                Screen("friends", R.drawable.vuesax_profile_2user, enabled = false),
                Screen("pet", R.drawable.vuesax_pet, enabled = false),
                settingsNavigationItem,
            )
        override val topRightNavItem = settingsNavigationItem
        override val displayFontFamily: FontFamily =
            FontFamily(
                Font(
                    googleFont = GoogleFont("Poppins"),
                    fontProvider = googleFontProvider,
                ),
            )

        override val bodyFontFamily: FontFamily =
            FontFamily(
                Font(
                    googleFont = GoogleFont("Quicksand"),
                    fontProvider = googleFontProvider,
                ),
            )

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
        override val statuses = setOf(inProgressStatus, doneStatus)

        override val defaultStatus = inProgressStatus

        private val normalPriority =
            GoalModel.Priority(
                label = "Normal",
                importance = GoalModel.Priority.Importance.Normal,
                iconResourceId = R.drawable.vuesax_minus_cirlce,
                getColor = @Composable { MaterialTheme.colorScheme.tertiary },
            )

        private val highPriority =
            GoalModel.Priority(
                label = "High",
                importance = GoalModel.Priority.Importance.High,
                iconResourceId = R.drawable.vuesax_warning_2,
                getColor = @Composable { MaterialTheme.colorScheme.error },
            )

        override val priorities = setOf(normalPriority, highPriority)

        override val defaultPriority = normalPriority

        override val numberExampleGoals = 12

        private val sortOptions =
            listOf(
                GoalSortOption(
                    "Date",
                    compareBy { it.createdAt },
                    uiIndex = 1,
                ),
                GoalSortOption(
                    "Priority",
                    compareBy { it.priority.importance },
                    uiIndex = 2,
                ),
            )

        override var defaultGoalQuery: GoalQuery

        init {
            val goalFilter =
                GoalFilter
                    .Builder
                    .matchAllBuilder(this, this)
                    .excludeStatus(doneStatus)
                    .build()

            defaultGoalQuery =
                GoalQuery(
                    filter = goalFilter,
                    sortOptions = this.sortOptions,
                    defaultComparator = compareBy<GoalModel> { it.isDone() }.thenBy { it.title },
                    priorityProvider = this,
                    statusProvider = this,
                )
        }
    }
