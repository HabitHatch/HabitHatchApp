package com.habithatch.demo.data.models

import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.GoalPriority

data class GoalFilter(
    val priorityVisibleMap: Map<GoalPriority, Boolean>,
    val doneStateVisibleMap: Map<GoalStatus, Boolean>,
    val searchQuery: String?
) {
    init {
        val allPriorities = GoalPriority.entries.toSet()
        require(priorityVisibleMap.keys == allPriorities) {
            "priorityVisibleMap must contain all values of GoalPriority exactly once."
        }

        val allDoneStates = GoalStatus.entries.toSet()
        require(doneStateVisibleMap.keys == allDoneStates) {
            "doneStateVisibleMap must contain all values of GoalStatus exactly once."
        }
    }
    companion object {
        fun matchAllFilter(): GoalFilter {
            return GoalFilter(
                    priorityVisibleMap = GoalPriority.entries.associateWith { true },
                    doneStateVisibleMap = GoalStatus.entries.associateWith { true },
                    searchQuery = null
            )
        }
    }
}
