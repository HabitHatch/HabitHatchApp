package com.habithatch.demo.ui.goals

import androidx.compose.runtime.Stable
import com.habithatch.demo.core.query.GoalSortOption

/**
 * The state of the goal sort.
 *
 * @param sortOptions The list of sort options.
 * @param onSortOptionChange The action to be performed when the sort option changes.
 */
@Stable
class GoalSortState(
    val sortOptions: List<GoalSortOption>,
    val onSortOptionChange: (GoalSortOption) -> Unit = { },
)
