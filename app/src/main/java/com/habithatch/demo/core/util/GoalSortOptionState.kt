package com.habithatch.demo.core.util

data class GoalSortOptionState(
    val sortState: SortState,
    val sortOption: GoalSortOption
) {
    fun nextStateInCycle(): GoalSortOptionState {
        return this.copy(sortState = sortState.nextInCycle())
    }
}