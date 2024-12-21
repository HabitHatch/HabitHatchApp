package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.GoalModel


sealed class GoalSortOption (
    val label: String,
    val comparator: Comparator<GoalModel>
){
    object ByPriority : GoalSortOption(
        "Priority",
        compareByDescending<GoalModel> { it.priority.importance }
    )
    object ByTitle : GoalSortOption(
        "Title",
        compareBy<GoalModel> { it.title }
    )

    fun toSortConfig(): SortConfig<GoalModel> {
        return SortConfig(comparator)
    }
}