package com.habithatch.demo.features.home

import BottomNavBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.theme.AppTheme
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialog
import com.habithatch.demo.ui.goals.GoalQueryTable
import com.habithatch.demo.ui.goals.GoalsView
import com.habithatch.demo.ui.navigation.TopNavBar
import com.habithatch.demo.ui.pets.PetAnimation
import java.util.UUID

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen(
    topAppInformationBar: @Composable () -> Unit,
    bottomNavigationBar: @Composable () -> Unit,
    config: HabitHatchConfig = hiltViewModel<HomeViewModel>().config,
    state: HomeScreenState = rememberHomeScreenState(),
) {
    if (state.user == null) return

    Scaffold(
        topBar = topAppInformationBar,
        bottomBar = bottomNavigationBar,
        floatingActionButton = {
            FloatingActionButton(onClick = state.onAddGoalClicked) {
                Icon(Icons.Default.Add, "Add Goal")
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            PetAnimation(
                pet = state.user.pet,
                isPetHappy = state.allGoalsDone,
                modifier =
                    Modifier
                        .fillMaxWidth(0.6f)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
            )
            GoalQueryTable(
                goalQuery = state.goalQuery,
                allStatuses = config.statuses,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 8.dp, end = 8.dp),
                onGoalQueryChange = state.onGoalQueryChange,
                goalsContent = {
                    GoalsView(
                        goals = state.goals,
                        onToggleGoalStatus = state.onToggleGoalStatus,
                        showCreateExampleGoalsButton = !state.hasAnyGoals,
                        onCreateExampleGoalsClicked = state.onCreateExampleGoalsClicked,
                    )
                },
            )
        }
    }

    if (state.showDialog) {
        AddGoalDialog(
            allPriorities = config.priorities,
            preselectedGoal = GoalModel(config.defaultStatus, config.defaultPriority),
            onDismiss = state.onGoalDialogDismissed,
            onAdd = state.onGoalAdded,
        )
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE, showBackground = true, showSystemUi = true)
@Preview(wallpaper = Wallpapers.NONE, showBackground = true, showSystemUi = true, device = "id:pixel_7")
@Composable
fun HomeScreenPreview() {
    val config = HabitHatchDevConfig(AppModule.provideGoogleFontProvider())

    AppTheme(
        typography = MaterialTheme.typography,
        darkTheme = true,
    ) {
        HomeScreen(
            topAppInformationBar = {
                TopNavBar(
                    title = "HabitHatch",
                    primaryNavigationItem = config.primaryNavigationItem,
                )
            },
            bottomNavigationBar = {
                BottomNavBar(
                    navigationItems = config.navigationItems,
                    activeNavigationItem = config.homeNavigationItem,
                ) { }
            },
            config = config,
            state =
                HomeScreenState(
                    user =
                        User(
                            uuid = UUID.randomUUID().toString(),
                            pet = config.pets[0],
                        ),
                    goals = config.exampleGoals,
                    allGoalsDone = false,
                    goalQuery = config.getDefaultGoalQuery(),
                    showDialog = false,
                    hasAnyGoals = true,
                    onAddGoalClicked = {},
                    onGoalDialogDismissed = {},
                    onGoalAdded = {},
                    onGoalQueryChange = {},
                    onToggleGoalStatus = {},
                ),
        )
    }
}
