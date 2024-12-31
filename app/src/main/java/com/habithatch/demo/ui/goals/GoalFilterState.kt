package com.habithatch.demo.ui.goals

import androidx.compose.runtime.Stable
import com.habithatch.demo.core.query.GoalFilter

@Stable
class GoalFilterState(
    val goalFilterBuilder: GoalFilter.Builder,
    val onGoalFilterChange: (GoalFilter) -> Unit = {},
)
