package com.habithatch.demo.data.models

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.exceptions.InvalidGoalFilterException


/**
 * Filters goals based on priority and status.
 *
 * @param priorityVisibleMap Maps each priority to its visibility.
 * @param statusVisibleMap Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering goals.
 */
@ConsistentCopyVisibility
data class GoalFilter private constructor(
    val priorityVisibleMap: Map<GoalModel.Priority, Boolean>,
    val statusVisibleMap: Map<GoalModel.Status, Boolean>,
    val searchQuery: String?,
) {
    fun builder(): Builder {
        return Builder(this)
    }

    fun isMatch(goal: GoalModel): Boolean {
        if (statusVisibleMap.containsKey(goal.status).not()) {
            throw InvalidGoalFilterException(this, "Goal status not found in statusVisibleMap")
        }
        if (priorityVisibleMap.containsKey(goal.priority).not()) {
            throw InvalidGoalFilterException(this, "Goal priority not found in priorityVisibleMap")
        }

        val matchesDone = statusVisibleMap[goal.status]!!
        val matchesPriority = priorityVisibleMap[goal.priority]!!
        val matchesSearch = this.matchesSearchQuery(goal)
        return matchesDone && matchesPriority && matchesSearch
    }

    private fun matchesSearchQuery(goal: GoalModel): Boolean {
        return notHasSearchQuery() || goal.title.contains(searchQuery!!, ignoreCase = true)
    }

    private fun hasSearchQuery(): Boolean {
        return searchQuery.isNullOrBlank()
    }

    private fun notHasSearchQuery(): Boolean {
        return !hasSearchQuery()
    }

    class Builder(
        goalFilter: GoalFilter
    ) {
        private var priorityVisibleMap = goalFilter.priorityVisibleMap
        private var statusVisibleMap = goalFilter.statusVisibleMap
        private var searchQuery = goalFilter.searchQuery

        @Inject
        constructor(
            config: HabitHatchConfig
        ) : this(
                GoalFilter(
                        priorityVisibleMap = config.priorities.associateWith { false },
                        statusVisibleMap = config.statuses.associateWith { false },
                        searchQuery = null
                )
        )

        fun createMatchAll(): Builder {
            this.priorityVisibleMap = this.priorityVisibleMap.keys.associateWith { true }
            this.statusVisibleMap = this.statusVisibleMap.keys.associateWith { true }
            return this
        }

        fun setPriorityVisibility(priority: GoalModel.Priority, visible: Boolean): Builder {
            this.priorityVisibleMap = this.priorityVisibleMap.toMutableMap().apply {
                this[priority] = visible
            }
            return this
        }

        fun setStatusVisibility(status: GoalModel.Status, visible: Boolean): Builder {
            this.statusVisibleMap = this.statusVisibleMap.toMutableMap().apply {
                this[status] = visible
            }
            return this
        }

        fun excludeStatus(status: GoalModel.Status): Builder {
            return setStatusVisibility(status, false)
        }

        fun setSearchQuery(searchQuery: String): Builder {
            this.searchQuery = searchQuery
            return this
        }

        fun build(): GoalFilter {
            return GoalFilter(
                    priorityVisibleMap = priorityVisibleMap,
                    statusVisibleMap = statusVisibleMap,
                    searchQuery = searchQuery,
            )
        }
    }
}
