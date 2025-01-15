package com.habithatch.demo.core.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.habithatch.demo.R
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.HabitFilter
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.core.query.HabitSortOption
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.ExampleHabitFactory
import com.habithatch.demo.data.models.HabitModel
import javax.inject.Inject

/**
 * The main application configuration for the development environment.
 */
class HabitHatchDevConfig
    @Inject
    constructor(
        googleFontProvider: GoogleFont.Provider,
        habitModelFactory: HabitModel.Factory,
    ) : HabitHatchConfig {
        override val pets =
            listOf(
                Pet(name = "Cat", imageRes = R.mipmap.pet_cat),
                Pet(name = "Fox", imageRes = R.mipmap.pet_fox),
                Pet(name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
                Pet(name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear),
            )

        override val signUpNavigationItem = Screen("sign_up", R.drawable.vuesax_profile_circle)
        override val homeNavigationItem = Screen("home", R.drawable.vuesax_home_2)
        override val settingsNavigationItem = Screen("settings", R.drawable.vuesax_profile_circle)

        override val aiNavItem = Screen("ai", R.drawable.vuesax_microphone_2)

        override val navigationItems =
            listOf(
                homeNavigationItem,
                Screen("habits", R.drawable.vuesax_flag, enabled = false),
                Screen("friends", R.drawable.vuesax_profile_2user, enabled = false),
                Screen("pet", R.drawable.vuesax_pet, enabled = false),
                settingsNavigationItem,
                aiNavItem,
            )
        override val topLeftNavItem = aiNavItem
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
            HabitModel.Status(
                label = "In Progress",
                stepNumber = 1,
                isDone = false,
            )

        private val doneStatus =
            HabitModel.Status(
                label = "Done",
                stepNumber = 2,
                isDone = true,
            )
        override val statuses = setOf(inProgressStatus, doneStatus)

        override val defaultStatus = inProgressStatus

        private val normalPriority =
            HabitModel.Priority(
                label = "Normal",
                importance = HabitModel.Priority.Importance.Normal,
                iconResourceId = R.drawable.vuesax_minus_cirlce,
                getColor = @Composable { MaterialTheme.colorScheme.tertiary },
            )

        private val highPriority =
            HabitModel.Priority(
                label = "High",
                importance = HabitModel.Priority.Importance.High,
                iconResourceId = R.drawable.vuesax_warning_2,
                getColor = @Composable { MaterialTheme.colorScheme.error },
            )

        override val priorities = setOf(normalPriority, highPriority)

        override val defaultPriority = normalPriority
        val numberExampleHabits = 12
        override val exampleHabits =
            ExampleHabitFactory(this, this, habitModelFactory)
                .createExampleHabits(numberExampleHabits, uniqueTitles = true)

        private val sortOptions =
            listOf(
                HabitSortOption(
                    "Date",
                    compareBy { it.createdAt },
                    uiIndex = 1,
                ),
                HabitSortOption(
                    "Priority",
                    compareBy { it.priority.importance },
                    uiIndex = 2,
                ),
            )

        override var defaultHabitQuery: HabitQuery
            private set

        init {
            val habitFilter =
                HabitFilter
                    .Builder
                    .matchAllBuilder(this, this)
                    .excludeStatus(doneStatus)
                    .build()

            defaultHabitQuery =
                HabitQuery(
                    filter = habitFilter,
                    sortOptions = this.sortOptions,
                    defaultComparator = compareBy<HabitModel> { it.isDone() }.thenBy { it.title },
                    priorityProvider = this,
                    statusProvider = this,
                )
        }
    }
