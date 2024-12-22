package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.GoalModel


sealed class GoalSortOption(
    val label: String,
    val comparator: Comparator<GoalModel>,
    var sortState: SortState = SortState.NOT_USED
) {
    object ByPriority : GoalSortOption(
            "Priority",
            compareByDescending<GoalModel> { it.priority.importance }
    )

    object ByTitle : GoalSortOption(
            "Title",
            compareBy<GoalModel> { it.title }
    )

    fun toSortConfig(): SortConfig<GoalModel> {
        val effectiveComparator = if (sortState == SortState.DESCENDING) comparator.reversed() else comparator
        return SortConfig(effectiveComparator, sortState != SortState.DESCENDING)
    }

    fun cycleState() {
        sortState = sortState.nextInCycle()
    }
    override fun hashCode(): Int {
        return label.hashCode() * 31 + comparator.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoalSortOption

        if (label != other.label) return false
        if (comparator != other.comparator) return false

        return true
    }
}

