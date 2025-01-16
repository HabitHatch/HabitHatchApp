package com.habithatch.demo.core.config

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.habithatch.demo.R
import com.habithatch.demo.core.animation.FrameStateAnimation
import com.habithatch.demo.core.animation.ImageStateAnimation
import com.habithatch.demo.core.navigation.Screen
import com.habithatch.demo.core.query.HabitFilter
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.core.query.HabitSortOption
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.PetMood
import com.habithatch.demo.data.entities.PetMoodAnimations
import com.habithatch.demo.data.entities.PetMoodAnimationsFactory
import com.habithatch.demo.data.models.HabitModel
import javax.inject.Inject

/**
 * The main application configuration for the development environment.
 */
class HabitHatchDevConfig
    @Inject
    constructor(
        googleFontProvider: GoogleFont.Provider,
        petMoodAnimationsBuilder: PetMoodAnimationsFactory,
    ) : HabitHatchConfig {
        val happyCatAnimation =
            FrameStateAnimation.createFromImages(
                listOf(
                    R.mipmap.cat_happy_0000,
                    R.mipmap.cat_happy_0001,
                    R.mipmap.cat_happy_0002,
                    R.mipmap.cat_happy_0003,
                    R.mipmap.cat_happy_0004,
                    R.mipmap.cat_happy_0005,
                    R.mipmap.cat_happy_0006,
                    R.mipmap.cat_happy_0007,
                    R.mipmap.cat_happy_0008,
                    R.mipmap.cat_happy_0009,
                    R.mipmap.cat_happy_0010,
                    R.mipmap.cat_happy_0011,
                    R.mipmap.cat_happy_0012,
                    R.mipmap.cat_happy_0013,
                    R.mipmap.cat_happy_0014,
                    R.mipmap.cat_happy_0015,
                    R.mipmap.cat_happy_0016,
                    R.mipmap.cat_happy_0017,
                    R.mipmap.cat_happy_0018,
                    R.mipmap.cat_happy_0019,
                ),
                duration = 100,
            )

        val sadCatAnimation =
            FrameStateAnimation.createFromImages(
                listOf(
                    R.mipmap.cat_sad_0000,
                    R.mipmap.cat_sad_0001,
                    R.mipmap.cat_sad_0002,
                    R.mipmap.cat_sad_0003,
                    R.mipmap.cat_sad_0004,
                    R.mipmap.cat_sad_0005,
                    R.mipmap.cat_sad_0006,
                    R.mipmap.cat_sad_0007,
                    R.mipmap.cat_sad_0008,
                    R.mipmap.cat_sad_0009,
                    R.mipmap.cat_sad_0010,
                    R.mipmap.cat_sad_0011,
                    R.mipmap.cat_sad_0012,
                    R.mipmap.cat_sad_0013,
                    R.mipmap.cat_sad_0014,
                    R.mipmap.cat_sad_0015,
                    R.mipmap.cat_sad_0016,
                    R.mipmap.cat_sad_0017,
                    R.mipmap.cat_sad_0018,
                    R.mipmap.cat_sad_0019,
                ),
                duration = 100,
            )

        val catAnimation: PetMoodAnimations =
            mapOf(
                PetMood.HAPPY to happyCatAnimation,
                PetMood.SAD to sadCatAnimation,
            )

        override val pets =
            listOf(
                Pet(
                    id = 1,
                    name = "Cat",
                    coverImage = R.mipmap.cat,
                    petMoodAnimations = catAnimation,
                ),
                Pet(
                    id = 2,
                    name = "Fox",
                    coverImage = R.mipmap.panda,
                    petMoodAnimations =
                        petMoodAnimationsBuilder
                            .create(
                                ImageStateAnimation(R.mipmap.panda),
                            ),
                ),
                Pet(
                    id = 3,
                    name = "Rabbit",
                    coverImage = R.mipmap.rabbit,
                    petMoodAnimations =
                        petMoodAnimationsBuilder
                            .create(
                                ImageStateAnimation(R.mipmap.rabbit),
                            ),
                ),
                Pet(
                    id = 4,
                    name = "Ice Bear",
                    coverImage = R.mipmap.wolf,
                    petMoodAnimations =
                        petMoodAnimationsBuilder
                            .create(
                                ImageStateAnimation(R.mipmap.wolf),
                            ),
                ),
            )

        override val signUpNavItem = Screen("sign_up", R.drawable.vuesax_profile_circle)
        override val homeNavItem = Screen("home", R.drawable.vuesax_home_2)
        override val settingsNavigationItem = Screen("settings", R.drawable.vuesax_profile_circle)

        override val navItems =
            listOf(
                homeNavItem,
                Screen("habits", R.drawable.vuesax_flag, enabled = false),
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

        override val numberExampleHabits = 12

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

        init {
            val habitFilterBuilder =
                HabitFilter
                    .Builder
                    .matchAllBuilder(this, this)
                    .excludeStatus(doneStatus)

            defaultHabitQuery =
                HabitQuery(
                    filterBuilder = habitFilterBuilder,
                    sortOptions = this.sortOptions,
                    defaultComparator = compareBy<HabitModel> { it.isDone() }.thenBy { it.title },
                )
        }
    }
