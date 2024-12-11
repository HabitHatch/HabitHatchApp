package com.habithatch.demo.data.models

import com.habithatch.demo.data.entities.GoalPriority

class GoalFilter private constructor(
    val possiblePriorities: List<GoalPriority>,
    val isDone: Boolean?,
    val searchQuery: String?
) {

    class Builder {
        private var possiblePriorities: List<GoalPriority> = GoalPriority.entries
        private var isDone: Boolean? = null
        private var searchQuery: String? = null

        fun filterByPriorities(priorities: List<GoalPriority>) = apply { this.possiblePriorities = priorities }
        fun filterByPriority(priority: GoalPriority) = apply { this.possiblePriorities = listOf(priority) }
        fun filterByPriority(vararg priorities: GoalPriority) = apply { this.possiblePriorities = priorities.toList() }
        fun filterByDoneGoals() = apply { this.isDone = true }
        fun filterByUndoneGoals() = apply { this.isDone = false }
        fun filterBySearchQuery(query: String?) = apply { this.searchQuery = query }

        fun matchAll() = apply {
            this.possiblePriorities = GoalPriority.entries
            this.isDone = null
            this.searchQuery = null
        }

        fun build(): GoalFilter {
            return GoalFilter(possiblePriorities, isDone, searchQuery)
        }
    }

    companion object {
        val defaultFilter: GoalFilter = Builder()
            .filterByDoneGoals()
            .build()

        val matchAllFilter: GoalFilter = Builder()
            .matchAll()
            .build()
    }
}
