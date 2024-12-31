package com.habithatch.demo.ui.goals

import androidx.compose.runtime.Stable
import com.habithatch.demo.core.query.GoalSortOption

@Stable
class GoalSortState(
    val sortOptions: List<GoalSortOption>,
    val onSortOptionChange: (GoalSortOption) -> Unit = { },
)
