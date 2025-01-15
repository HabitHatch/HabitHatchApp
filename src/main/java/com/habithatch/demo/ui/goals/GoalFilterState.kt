package com.habithatch.demo.ui.goals

import androidx.compose.runtime.Stable
import com.habithatch.demo.core.query.GoalFilter

/**
 * The state of the goal filter.
 *
 * @param goalFilterBuilder The builder of the goal filter.
 * @param onGoalFilterChange The action to be performed when the goal filter changes.
 */
@Stable
class GoalFilterState(
    val goalFilterBuilder: GoalFilter.Builder,
    val onGoalFilterChange: (GoalFilter.Builder) -> Unit = {},
)
