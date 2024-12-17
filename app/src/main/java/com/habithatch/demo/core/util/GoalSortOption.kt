package com.habithatch.demo.core.util

import com.habithatch.demo.data.entities.Goal

sealed class GoalSortOption (
    val label: String,
    val comparator: Comparator<Goal>
){
    object ByPriority : GoalSortOption(
        "Priority",
        compareByDescending<Goal> { it.priority.importance }
    )
    object ByTitle : GoalSortOption(
        "Title",
        compareBy<Goal> { it.title }
    )
}