package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.GoalModel


data class GoalSortOption(
    val label: String,
    val comparator: Comparator<GoalModel>,
    val sortState: SortState = SortState.NOT_USED
) {
    fun toSortConfig(): SortConfig<GoalModel> {
        return when (sortState) {
            SortState.ASCENDING -> SortConfig(comparator, true)
            SortState.DESCENDING -> SortConfig(comparator, false)
            else -> throw IllegalStateException("Sort state is not used")
        }
    }

    fun cycleState(): GoalSortOption {
        return this.copy(sortState = sortState.nextInCycle())
    }

    override fun toString(): String {
        return "GoalSortOption(label='$label', sortState=$sortState)"
    }
}

