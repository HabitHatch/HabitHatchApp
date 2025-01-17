package com.habithatch.demo.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.UUID
import com.habithatch.demo.R
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.query.HabitFilterBuilderFactory
import com.habithatch.demo.core.theme.AppTheme
import com.habithatch.demo.data.entities.PetMoodAnimationsFactory
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.ui.habits.AddHabitDialog
import com.habithatch.demo.ui.habits.AddHabitDialogState
import com.habithatch.demo.ui.habits.HabitFilterState
import com.habithatch.demo.ui.habits.HabitSortState
import com.habithatch.demo.ui.habits.HabitsView
import com.habithatch.demo.ui.habits.HabitsViewState
import com.habithatch.demo.ui.habits.table.HabitFilterBar
import com.habithatch.demo.ui.habits.table.HabitQueryTable
import com.habithatch.demo.ui.habits.table.HabitSortBar
import com.habithatch.demo.ui.navigation.BottomNavBar
import com.habithatch.demo.ui.navigation.TopNavBar
import com.habithatch.demo.ui.pets.PetAnimation

/**
 * The main screen of the application.
 * Shows the user's pet and habits.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming", "MagicNumber")
@Composable
fun HomeScreen(
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
    state: HomeScreenState? = rememberHomeScreenState(),
) {
    if (state == null) return

    Scaffold(
        topBar = topNavBar,
        bottomBar = bottomNavBar,
        floatingActionButton = {
            FloatingActionButton(onClick = state.core.onFabClicked) {
                Icon(Icons.Default.Add, stringResource(R.string.add_habit_icon_description))
            }
        },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            PetAnimation(
                pet = state.core.pet,
                modifier =
                    Modifier
                        .fillMaxWidth(0.6f)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
            )
            HabitQueryTable(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 8.dp, end = 8.dp),
                filterContent = { defaultModifier ->
                    HabitFilterBar(
                        modifier = defaultModifier,
                        state = state.habitFilterState,
                    )
                },
                sortContent = { defaultModifier ->
                    HabitSortBar(
                        modifier = defaultModifier,
                        state = state.habitSortState,
                    )
                },
                habitsContent = { HabitsView(state = state.habitsViewState) },
            )
        }
    }

    AddHabitDialog(state = state.addHabitDialogState)
}

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val config =
        HabitHatchDevConfig(
            AppModule().provideGoogleFontProvider(),
            PetMoodAnimationsFactory(),
        )

    AppTheme(
        typography = MaterialTheme.typography,
    ) {
        HomeScreen(
            topNavBar = {
                TopNavBar(
                    title = "HabitHatch",
                    rightNavItem = config.topRightNavItem,
                )
            },
            bottomNavBar = {
                BottomNavBar(
                    navigationItems = config.navItems,
                    activeNavScreen = config.homeNavItem,
                )
            },
            state =
                HomeScreenState(
                    core = CoreHomeState(pet = config.pets[0]),
                    habitsViewState = HabitsViewState(habits = emptyList()),
                    addHabitDialogState =
                        AddHabitDialogState(
                            habit =
                                HabitModel
                                    .Factory()
                                    .createDraft(
                                        userId = UUID.randomUUID(),
                                        title = "Test",
                                        priority = config.defaultPriority,
                                        status = config.defaultStatus,
                                    ),
                            allPriorities = config.priorities,
                        ),
                    habitFilterState =
                        HabitFilterState(
                            habitFilterBuilder = HabitFilterBuilderFactory(config, config).matchAllBuilder,
                        ),
                    habitSortState =
                        HabitSortState(
                            sortOptions = config.defaultHabitQuery.sortOptions,
                        ),
                ),
        )
    }
}
