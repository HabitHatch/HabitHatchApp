package com.habithatch.demo.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.ui.habits.AddHabitDialogState
import com.habithatch.demo.ui.habits.HabitFilterState
import com.habithatch.demo.ui.habits.HabitSortState
import com.habithatch.demo.ui.habits.HabitsViewState

/** Represents the state of the home screen.*/
@Stable
class HomeScreenState(
    val habitsViewState: HabitsViewState,
    val habitFilterState: HabitFilterState,
    val core: CoreHomeState,
    val addHabitDialogState: AddHabitDialogState = AddHabitDialogState(),
    val habitSortState: HabitSortState = HabitSortState(emptyList()),
)

/**@suppress*/
@Composable
fun rememberHomeScreenState(viewModel: HomeViewModel = hiltViewModel()): HomeScreenState? {
    val user by viewModel.user.collectAsStateWithLifecycle()
    val habits by viewModel.queriedHabits.collectAsStateWithLifecycle()
    val habitQuery by viewModel.habitQuery.collectAsStateWithLifecycle()
    val hasAnyHabits by viewModel.hasAnyHabits.collectAsStateWithLifecycle()

    var showDialog by remember { mutableStateOf(false) }
    if (user == null) return null
    val pet = user!!.pet

    val addHabitDialogState =
        remember(showDialog) {
            AddHabitDialogState(
                showDialog = showDialog,
                habit =
                    HabitModel.Factory().createDraft(
                        userId = user!!.uuid,
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
        remember(pet, showDialog) {
            CoreHomeState(
                pet = pet,
                onFabClicked = { showDialog = true },
            )
        }

    val habitFilterState =
        remember(habitQuery) {
            HabitFilterState(
                habitFilterBuilder = habitQuery.filterBuilder,
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

    return remember(addHabitDialogState, habitsViewState, habitFilterState, habitSortState, coreHomeState) {
        HomeScreenState(
            addHabitDialogState = addHabitDialogState,
            habitsViewState = habitsViewState,
            habitFilterState = habitFilterState,
            habitSortState = habitSortState,
            core = coreHomeState,
        )
    }
}
