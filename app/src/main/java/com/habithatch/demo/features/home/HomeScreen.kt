package com.habithatch.demo.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialog
import com.habithatch.demo.ui.goals.GoalQueryTable
import com.habithatch.demo.ui.goals.GoalsView
import com.habithatch.demo.ui.pets.PetAnimation

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
                        .padding(top = 8.dp),
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

@Stable
class HomeScreenState(
    val user: User?,
    val goals: List<GoalModel>,
    val allGoalsDone: Boolean,
    val goalQuery: GoalQuery,
    val showDialog: Boolean,
    val hasAnyGoals: Boolean,
    val onCreateExampleGoalsClicked: () -> Unit = {},
    val onAddGoalClicked: () -> Unit,
    val onGoalDialogDismissed: () -> Unit,
    val onGoalAdded: (GoalModel) -> Unit,
    val onGoalQueryChange: (GoalQuery) -> Unit,
    val onToggleGoalStatus: (GoalModel) -> Unit,
)

@Suppress("ktlint:standard:function-naming")
@Composable
fun rememberHomeScreenState(viewModel: HomeViewModel = hiltViewModel()): HomeScreenState {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val goals by viewModel.queriedGoals.collectAsStateWithLifecycle()
    val allGoalsDone by viewModel.allGoalsDone.collectAsStateWithLifecycle()
    val goalQuery by viewModel.goalQuery.collectAsStateWithLifecycle()
    val hasAnyGoals by viewModel.hasAnyGoals.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }
    return remember(user, goals, allGoalsDone, goalQuery, showDialog, hasAnyGoals) {
        HomeScreenState(
            user = user,
            goals = goals,
            allGoalsDone = allGoalsDone,
            goalQuery = goalQuery,
            showDialog = showDialog,
            hasAnyGoals = hasAnyGoals,
            onAddGoalClicked = { showDialog = true },
            onGoalAdded = {
                viewModel.addGoal(it)
                showDialog = false
            },
            onToggleGoalStatus = { viewModel.toggleGoalStatus(it) },
            onGoalQueryChange = { viewModel.updateGoalQuery(it) },
            onGoalDialogDismissed = { showDialog = false },
            onCreateExampleGoalsClicked = { viewModel.seedGoals() },
        )
    }
}
