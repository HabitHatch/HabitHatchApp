package com.habithatch.demo.ui.habits

import androidx.compose.runtime.Immutable
import com.habithatch.demo.data.models.HabitModel

/**
 * The state of the habits view.
 *
 * @param habits The list of habits.
 * @param showCreateExampleHabits Whether to show the create example habits button.
 * @param onCreateExampleHabits The action to be performed when the create example habits button is clicked.
 * @param onToggleHabitStatus The action to be performed when the habit status is toggled.
 */
@Immutable
data class HabitsViewState(
    val habits: List<HabitModel>,
    val showCreateExampleHabits: Boolean = true,
    val onCreateExampleHabits: () -> Unit = {},
    val onToggleHabitStatus: (HabitModel) -> Unit = {},
)
