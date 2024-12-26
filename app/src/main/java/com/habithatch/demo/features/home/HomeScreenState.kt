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
