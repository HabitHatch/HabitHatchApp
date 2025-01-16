package com.habithatch.demo.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialogState
import com.habithatch.demo.ui.goals.GoalFilterState
import com.habithatch.demo.ui.goals.GoalSortState
import com.habithatch.demo.ui.goals.GoalsViewState

/** Represents the state of the home screen.*/
@Stable
class HomeScreenState(
    val goalsViewState: GoalsViewState,
    val goalFilterState: GoalFilterState,
    val core: CoreHomeState,
    val addGoalDialogState: AddGoalDialogState = AddGoalDialogState(),
    val goalSortState: GoalSortState = GoalSortState(emptyList()),
)

/**@suppress*/
@Composable
fun rememberHomeScreenState(viewModel: HomeViewModel = hiltViewModel()): HomeScreenState? {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val goals by viewModel.queriedGoals.collectAsStateWithLifecycle()
    val goalQuery by viewModel.goalQuery.collectAsStateWithLifecycle()
    val hasAnyGoals by viewModel.hasAnyGoals.collectAsStateWithLifecycle()

    var showDialog by remember { mutableStateOf(false) }
    if (user == null) return null
    val pet = user!!.pet

    val addGoalDialogState =
        remember(showDialog) {
            AddGoalDialogState(
                showDialog = showDialog,
                goal =
                    GoalModel.Factory().createDraft(
                        userId = user!!.uuid,
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
        remember(goals, hasAnyGoals) {
            GoalsViewState(
                goals = goals,
                showCreateExampleGoals = !hasAnyGoals,
                onCreateExampleGoals = viewModel::seedGoals,
                onToggleGoalStatus = viewModel::toggleGoalStatus,
            )
        }

    val coreHomeState =
        remember(pet, showDialog) {
            CoreHomeState(
                pet = pet,
                onFabClicked = { showDialog = true },
            )
        }

    val goalFilterState =
        remember(goalQuery) {
            GoalFilterState(
                goalFilterBuilder = goalQuery.filterBuilder,
                onGoalFilterChange = viewModel::updateGoalFilter,
            )
        }

    val goalSortState =
        remember(goalQuery) {
            GoalSortState(
                sortOptions = goalQuery.sortOptions,
                onSortOptionChange = viewModel::updateGoalSortOption,
            )
        }

    return remember(addGoalDialogState, goalsViewState, goalFilterState, goalSortState, coreHomeState) {
        HomeScreenState(
            addGoalDialogState = addGoalDialogState,
            goalsViewState = goalsViewState,
            goalFilterState = goalFilterState,
            goalSortState = goalSortState,
            core = coreHomeState,
        )
    }
}
