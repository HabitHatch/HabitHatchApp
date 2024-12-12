package com.habithatch.demo.data.models

import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority

data class GoalFilter(
    val priorityVisibleMap: Map<GoalPriority, Boolean>,
    val doneStateVisibleMap: Map<GoalDoneState, Boolean>,
    val searchQuery: String?
) {

    class Builder{
        private var priorityVisibleMap: MutableMap<GoalPriority, Boolean> =
            GoalPriority.entries.associateWith { true } as MutableMap<GoalPriority, Boolean>
        private var doneStateVisibleMap: MutableMap<GoalDoneState, Boolean> =
            GoalDoneState.entries.associateWith { true } as MutableMap<GoalDoneState, Boolean>
        private var searchQuery: String? = null
        constructor()

        private constructor(
            prioritiesToBeShownMap: MutableMap<GoalPriority, Boolean>,
            possibleIsDoneStates: MutableMap<GoalDoneState, Boolean>,
            searchQuery: String?
        ){
            this.priorityVisibleMap = prioritiesToBeShownMap
            this.doneStateVisibleMap = possibleIsDoneStates
            this.searchQuery = searchQuery
        }

        fun hidePriority(priority: GoalPriority) = apply {
            priorityVisibleMap[priority] = false
        }

        fun hidePriorities(priorities: List<GoalPriority>) = apply {
            priorities.forEach { hidePriority(it) }
        }


        fun showPriority(priority: GoalPriority) = apply {
            priorityVisibleMap[priority] = true
        }

        fun showPriorities(priorities: List<GoalPriority>) = apply {
            priorities.forEach { showPriority(it) }
        }

        fun setDoneStateVisible(doneState: GoalDoneState, visible: Boolean) = apply {
            this.doneStateVisibleMap[doneState] = visible
        }

        fun filterBySearchQuery(query: String?) = apply { this.searchQuery = query }

        fun copy(): Builder{
            return Builder(priorityVisibleMap, doneStateVisibleMap, searchQuery)
        }
        fun build(): GoalFilter {
            return GoalFilter(priorityVisibleMap, doneStateVisibleMap, searchQuery)
        }
    }
}
