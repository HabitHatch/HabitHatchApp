package com.habithatch.demo.data.models

import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority

data class GoalFilter(
    val priorityVisibleMap: Map<GoalPriority, Boolean>,
    val doneStateVisibleMap: Map<GoalDoneState, Boolean>,
    val searchQuery: String?
) {
    init {
        val allPriorities = GoalPriority.entries.toSet()
        require(priorityVisibleMap.keys == allPriorities) {
            "priorityVisibleMap must contain all values of GoalPriority exactly once."
        }

        val allDoneStates = GoalDoneState.entries.toSet()
        require(doneStateVisibleMap.keys == allDoneStates) {
            "doneStateVisibleMap must contain all values of GoalDoneState exactly once."
        }
    }
    companion object {
        fun matchAllFilter(): GoalFilter {
            return GoalFilter(
                    priorityVisibleMap = GoalPriority.entries.associateWith { true },
                    doneStateVisibleMap = GoalDoneState.entries.associateWith { true },
                    searchQuery = null
            )
        }
    }
}
