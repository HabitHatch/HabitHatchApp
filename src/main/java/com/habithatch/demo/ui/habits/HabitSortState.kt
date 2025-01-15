package com.habithatch.demo.ui.habits

import androidx.compose.runtime.Stable
import com.habithatch.demo.core.query.HabitSortOption

/**
 * The state of the habit sort.
 *
 * @param sortOptions The list of sort options.
 * @param onSortOptionChange The action to be performed when the sort option changes.
 */
@Stable
class HabitSortState(
    val sortOptions: List<HabitSortOption>,
    val onSortOptionChange: (HabitSortOption) -> Unit = { },
)
