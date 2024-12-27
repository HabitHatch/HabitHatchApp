package com.habithatch.demo.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialogState
import com.habithatch.demo.ui.goals.GoalsViewState

data class HomeState(
    val user: User?,
    val goalQuery: GoalQuery,
    val allGoalsDone: Boolean,
    val onAddGoalClicked: () -> Unit,
    val onGoalQueryChange: (GoalQuery) -> Unit,
)

@Stable
class HomeScreenState(
    val addGoalDialogState: AddGoalDialogState,
    val goalsViewState: GoalsViewState,
    val homeState: HomeState,
)

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun rememberHomeScreenState(viewModel: HomeViewModel = hiltViewModel()): HomeScreenState {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val goals by viewModel.queriedGoals.collectAsStateWithLifecycle()
    val allGoalsDone by viewModel.allGoalsDone.collectAsStateWithLifecycle()
    val goalQuery by viewModel.goalQuery.collectAsStateWithLifecycle()
    val hasAnyGoals by viewModel.hasAnyGoals.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }

    val addGoalDialogState =
        remember(showDialog) {
            AddGoalDialogState(
                showDialog = showDialog,
                goal =
                    GoalModel(
                        priority = viewModel.config.defaultPriority,
                        status = viewModel.config.defaultStatus,
                    ),
                    allPriorities = viewModel.config.priorities,
                onAddGoal = {
                    viewModel.addGoal(it)
                    showDialog = false
                },
                onDismiss = { showDialog = false },
            )
        }

    val goalsViewState =
        remember {
            GoalsViewState(
                goals = goals,
                showCreateExampleGoals = hasAnyGoals,
                onCreateExampleGoals = viewModel::seedGoals,
                onToggleGoalStatus = viewModel::toggleGoalStatus,
            )
        }
    val homeState =
        remember(user, allGoalsDone, goalQuery) {
            HomeState(
                user = user,
                allGoalsDone = allGoalsDone,
                goalQuery = goalQuery,
                onGoalQueryChange = viewModel::updateGoalQuery,
                onAddGoalClicked = { showDialog = true },
            )
        }
    return remember(homeState, goalsViewState, addGoalDialogState) {
        HomeScreenState(
            addGoalDialogState = addGoalDialogState,
            goalsViewState = goalsViewState,
            homeState = homeState,
        )
    }
}
