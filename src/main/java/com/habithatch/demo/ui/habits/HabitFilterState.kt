package com.habithatch.demo.ui.habits

import androidx.compose.runtime.Stable
import com.habithatch.demo.core.query.HabitFilter

/**
 * The state of the habit filter.
 *
 * @param habitFilterBuilder The builder of the habit filter.
 * @param onHabitFilterChange The action to be performed when the habit filter changes.
 */
@Stable
class HabitFilterState(
    val habitFilterBuilder: HabitFilter.Builder,
    val onHabitFilterChange: (HabitFilter) -> Unit = {},
)
