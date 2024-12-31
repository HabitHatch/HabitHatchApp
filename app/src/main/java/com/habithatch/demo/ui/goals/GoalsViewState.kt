package com.habithatch.demo.ui.goals

import androidx.compose.runtime.Immutable
import com.habithatch.demo.data.models.GoalModel

/**
 * The state of the goals view.
 *
 * @param goals The list of goals.
 * @param showCreateExampleGoals Whether to show the create example goals button.
 * @param onCreateExampleGoals The action to be performed when the create example goals button is clicked.
 * @param onToggleGoalStatus The action to be performed when the goal status is toggled.
 */
@Immutable
data class GoalsViewState(
    val goals: List<GoalModel>,
    val showCreateExampleGoals: Boolean = true,
    val onCreateExampleGoals: () -> Unit = {},
    val onToggleGoalStatus: (GoalModel) -> Unit = {},
)
