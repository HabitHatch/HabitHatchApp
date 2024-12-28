package com.habithatch.demo.ui.goals

import androidx.compose.runtime.Immutable
import com.habithatch.demo.data.models.GoalModel

@Immutable
data class GoalsViewState(
    val goals: List<GoalModel>,
    val showCreateExampleGoals: Boolean,
    val onCreateExampleGoals: () -> Unit = {},
    val onToggleGoalStatus: (GoalModel) -> Unit = {},
)
