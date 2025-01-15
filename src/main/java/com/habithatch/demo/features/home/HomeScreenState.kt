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
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.ui.habits.AddHabitDialogState
import com.habithatch.demo.ui.habits.HabitFilterState
import com.habithatch.demo.ui.habits.HabitSortState
import com.habithatch.demo.ui.habits.HabitsViewState

/**
 * Represents the main state information for the home screen.
 *
 * @param pet The pet to display.
 * @param isUserLoggedIn Whether the user is logged in.
 * @param allHabitsDone Whether all habits are done.
 * @param onFabClicked The callback for when the Floating Action Button is clicked.
 */
data class CoreHomeState(
    val pet: Pet?,
    val isUserLoggedIn: Boolean = false,
    val allHabitsDone: Boolean = false,
    val onFabClicked: () -> Unit = {},
)

/**
 * Represents the state of the home screen.
 *
 * @param addHabitDialogState The state of the add habit dialog.
 * @param habitsViewState The state of the habits view.
 * @param habitFilterState The state of the habit filter.
 * @param habitSortState The state of the habit sort.
 * @param core The core state of the home screen.
 */
@Stable
class HomeScreenState(
    val addHabitDialogState: AddHabitDialogState,
    val habitsViewState: HabitsViewState,
    val habitFilterState: HabitFilterState,
    val habitSortState: HabitSortState,
    val core: CoreHomeState,
)

/**
 * @suppress
 */
@Composable
fun rememberHomeScreenState(viewModel: HomeViewModel = hiltViewModel()): HomeScreenState {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val habits by viewModel.queriedHabits.collectAsStateWithLifecycle()
    val allHabitsDone by viewModel.allHabitsDone.collectAsStateWithLifecycle()
    val habitQuery by viewModel.habitQuery.collectAsStateWithLifecycle()
    val hasAnyHabits by viewModel.hasAnyHabits.collectAsStateWithLifecycle()

    var showDialog by remember { mutableStateOf(false) }

    val addHabitDialogState =
        remember(showDialog) {
            AddHabitDialogState(
                showDialog = showDialog,
                habit =
                    HabitModel.Factory().createDraft(
                        priority = viewModel.config.defaultPriority,
                        status = viewModel.config.defaultStatus,
                    ),
                allPriorities = viewModel.config.priorities,
                onAddHabit = {
                    viewModel.addHabit(it)
                    showDialog = false
                },
                onDismiss = { showDialog = false },
            )
        }

    val habitsViewState =
        remember(habits, hasAnyHabits) {
            HabitsViewState(
                habits = habits,
                showCreateExampleHabits = !hasAnyHabits,
                onCreateExampleHabits = viewModel::seedHabits,
                onToggleHabitStatus = viewModel::toggleHabitStatus,
            )
        }

    val coreHomeState =
        remember(user, allHabitsDone, habitQuery, showDialog) {
            CoreHomeState(
                pet = user?.pet,
                isUserLoggedIn = user != null,
                allHabitsDone = allHabitsDone,
                onFabClicked = { showDialog = true },
            )
        }

    val habitFilterState =
        remember(habitQuery) {
            HabitFilterState(
                habitFilterBuilder = habitQuery.getFilterBuilder(),
                onHabitFilterChange = viewModel::updateHabitFilter,
            )
        }

    val habitSortState =
        remember(habitQuery) {
            HabitSortState(
                sortOptions = habitQuery.sortOptions,
                onSortOptionChange = viewModel::updateHabitSortOption,
            )
        }

    return remember(coreHomeState, habitsViewState, addHabitDialogState) {
        HomeScreenState(
            addHabitDialogState = addHabitDialogState,
            habitsViewState = habitsViewState,
            habitFilterState = habitFilterState,
            habitSortState = habitSortState,
            core = coreHomeState,
        )
    }
}
