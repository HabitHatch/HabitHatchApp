package com.habithatch.demo.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.AddGoalDialogState
import com.habithatch.demo.ui.goals.GoalFilterState
import com.habithatch.demo.ui.goals.GoalSortState
import com.habithatch.demo.ui.goals.GoalsViewState

/**
 * Represents the main state information for the home screen.
 */
data class CoreHomeState(
    val pet: Pet?,
    val isUserLoggedIn: Boolean = false,
    val allGoalsDone: Boolean = false,
    val onAddGoalClicked: () -> Unit = {},
)

/**
 * Represents the state of the home screen.
 *
 * @param addGoalDialogState The state of the add goal dialog.
 * @param goalsViewState The state of the goals view.
 * @param goalFilterState The state of the goal filter.
 * @param goalSortState The state of the goal sort.
 * @param core The core state of the home screen.
 */
@Stable
class HomeScreenState(
    val addGoalDialogState: AddGoalDialogState,
    val goalsViewState: GoalsViewState,
    val goalFilterState: GoalFilterState,
    val goalSortState: GoalSortState,
    val core: CoreHomeState,
)

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
                    GoalModel.Factory().createDraft(
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
        remember(user, allGoalsDone, goalQuery, showDialog) {
            CoreHomeState(
                pet = user?.pet,
                isUserLoggedIn = user != null,
                allGoalsDone = allGoalsDone,
                onAddGoalClicked = { showDialog = true },
            )
        }

    val goalFilterState =
        remember(goalQuery) {
            GoalFilterState(
                goalFilterBuilder = goalQuery.getFilterBuilder(),
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

    return remember(coreHomeState, goalsViewState, addGoalDialogState) {
        HomeScreenState(
            addGoalDialogState = addGoalDialogState,
            goalsViewState = goalsViewState,
            goalFilterState = goalFilterState,
            goalSortState = goalSortState,
            core = coreHomeState,
        )
    }
}
