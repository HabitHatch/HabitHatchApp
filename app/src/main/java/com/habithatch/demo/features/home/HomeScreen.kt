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
import com.habithatch.demo.ui.goals.AddGoalDialogState
import com.habithatch.demo.ui.goals.GoalsView
import com.habithatch.demo.ui.goals.GoalsViewState
import com.habithatch.demo.ui.goals.table.GoalQueryTable
import com.habithatch.demo.ui.navigation.TopNavBar
import com.habithatch.demo.ui.pets.PetAnimation

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun HomeScreen(
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
    config: HabitHatchConfig = hiltViewModel<HomeViewModel>().config,
    state: HomeScreenState = rememberHomeScreenState(),
) {
    if (state.homeState.user == null) return

    Scaffold(
        topBar = topNavBar,
        bottomBar = bottomNavBar,
        floatingActionButton = {
            FloatingActionButton(onClick = state.homeState.onAddGoalClicked) {
                Icon(Icons.Default.Add, "Add Goal")
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            PetAnimation(
                pet = state.homeState.user.pet,
                isPetHappy = state.homeState.allGoalsDone,
                modifier =
                    Modifier
                        .fillMaxWidth(0.6f)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
            )
            GoalQueryTable(
                goalQuery = state.homeState.goalQuery,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 8.dp, end = 8.dp),
                onGoalQueryChange = state.homeState.onGoalQueryChange,
                goalsContent = {
                    GoalsView(state = state.goalsViewState)
                },
            )
        }
    }

    if (state.addGoalDialogState.showDialog) {
        AddGoalDialog(
            state = state.addGoalDialogState,
        )
    }
}

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Preview(wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE, showBackground = true, showSystemUi = true)
@Preview(wallpaper = Wallpapers.NONE, showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val config = HabitHatchDevConfig(AppModule.provideGoogleFontProvider())

    AppTheme(
        typography = MaterialTheme.typography,
        darkTheme = true,
    ) {
        HomeScreen(
            topNavBar = {
                TopNavBar(
                    title = "HabitHatch",
                    primaryNavItem = config.primaryNavigationItem,
                )
            },
            bottomNavBar = {
                BottomNavBar(
                    navigationItems = config.navigationItems,
                    activeNavigationItem = config.homeNavigationItem,
                ) { }
            },
            config = config,
            state =
                HomeScreenState(
                    homeState =
                        HomeState(
                            allGoalsDone = false,
                            user = User(pet = config.pets[0]),
                            goalQuery = config.getDefaultGoalQuery(),
                            onAddGoalClicked = { },
                            onGoalQueryChange = { },
                        ),
                    goalsViewState =
                        GoalsViewState(
                            goals = emptyList(),
                            showCreateExampleGoals = true,
                            onToggleGoalStatus = { },
                            onCreateExampleGoals = { },
                        ),
                    addGoalDialogState =
                        AddGoalDialogState(
                            showDialog = false,
                            goal = GoalModel(config.defaultStatus, config.defaultPriority),
                            allPriorities = config.priorities,
                            onAddGoal = { },
                            onDismiss = { },
                        ),
                ),
        )
    }
}
