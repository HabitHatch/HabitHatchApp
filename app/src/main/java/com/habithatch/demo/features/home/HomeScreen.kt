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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.core.app.AppModule
import com.habithatch.demo.core.config.HabitHatchDevConfig
import com.habithatch.demo.core.theme.AppTheme
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialog
import com.habithatch.demo.ui.goals.AddGoalDialogState
import com.habithatch.demo.ui.goals.GoalFilterState
import com.habithatch.demo.ui.goals.GoalSortState
import com.habithatch.demo.ui.goals.GoalsView
import com.habithatch.demo.ui.goals.GoalsViewState
import com.habithatch.demo.ui.goals.table.GoalFilterBar
import com.habithatch.demo.ui.goals.table.GoalQueryTable
import com.habithatch.demo.ui.goals.table.GoalSortBar
import com.habithatch.demo.ui.navigation.TopNavBar
import com.habithatch.demo.ui.pets.PetAnimation

@Suppress("ktlint:standard:function-naming", "FunctionNaming", "MagicNumber")
@Composable
fun HomeScreen(
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
    state: HomeScreenState = rememberHomeScreenState(),
) {
    if (!state.core.isUserLoggedIn) return

    Scaffold(
        topBar = topNavBar,
        bottomBar = bottomNavBar,
        floatingActionButton = {
            FloatingActionButton(onClick = state.core.onAddGoalClicked) {
                Icon(Icons.Default.Add, stringResource(R.string.add_goal_icon_description))
            }
        },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            PetAnimation(
                pet = state.core.pet!!,
                isPetHappy = state.core.allGoalsDone,
                modifier =
                    Modifier
                        .fillMaxWidth(0.6f)
                        .padding(top = 8.dp)
                        .align(Alignment.CenterHorizontally),
            )
            GoalQueryTable(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 8.dp, end = 8.dp),
                filterContent = { defaultModifier ->
                    GoalFilterBar(
                        modifier = defaultModifier,
                        state = state.goalFilterState,
                    )
                },
                sortContent = { defaultModifier ->
                    GoalSortBar(
                        modifier = defaultModifier,
                        state = state.goalSortState,
                    )
                },
                goalsContent = { GoalsView(state = state.goalsViewState) },
            )
        }
    }

    AddGoalDialog(state = state.addGoalDialogState)
}

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val config =
        HabitHatchDevConfig(
            AppModule().provideGoogleFontProvider(),
            GoalModel.Factory(),
        )

    AppTheme(
        typography = MaterialTheme.typography,
        darkTheme = true,
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
                    navigationItems = config.navigationItems,
                    activeNavScreen = config.homeNavigationItem,
                )
            },
            state =
                HomeScreenState(
                    core = CoreHomeState(pet = config.pets[0]),
                    goalsViewState = GoalsViewState(goals = emptyList()),
                    addGoalDialogState =
                        AddGoalDialogState(
                            goal =
                                GoalModel
                                    .Factory()
                                    .createDraft(config.defaultStatus, config.defaultPriority),
                            allPriorities = config.priorities,
                        ),
                    goalFilterState =
                        GoalFilterState(
                            goalFilterBuilder = config.defaultGoalQuery.getFilterBuilder(),
                        ),
                    goalSortState =
                        GoalSortState(
                            sortOptions = config.defaultGoalQuery.sortOptions,
                        ),
                ),
        )
    }
}
