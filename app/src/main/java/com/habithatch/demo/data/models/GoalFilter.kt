package com.habithatch.demo.data.models

import javax.inject.Inject
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
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


    class Builder(
        goalFilter: GoalFilter
    ) {
        private var priorityVisibleMap = goalFilter.priorityVisibleMap
        private var statusVisibleMap = goalFilter.statusVisibleMap
        private var searchQuery = goalFilter.searchQuery

        @Inject
        constructor(
            priorityProvider: GoalPriorityProvider,
            statusProvider: GoalStatusProvider,
        ) : this(
                GoalFilter(
                        priorityVisibleMap = priorityProvider.priorities.associateWith { false },
                        statusVisibleMap = statusProvider.statuses.associateWith { false },
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

        @Throws(InvalidGoalFilterException::class)
        fun build(): GoalFilter {
            if (priorityVisibleMap.isEmpty()) {
                throw InvalidGoalFilterException("Priority visible map is empty")
            }

            if (statusVisibleMap.isEmpty()) {
                throw InvalidGoalFilterException("Status visible map is empty")
            }

            if (statusVisibleMap.values.any().not()) {
                throw InvalidGoalFilterException("At least one status must be visible")
            }

            if (priorityVisibleMap.values.any().not()) {
                throw InvalidGoalFilterException("At least one priority must be visible")
            }

            return GoalFilter(
                    priorityVisibleMap = priorityVisibleMap,
                    statusVisibleMap = statusVisibleMap,
                    searchQuery = searchQuery,
            )
        }
    }

    fun builder(): Builder {
        return Builder(this)
    }

    @Throws(InvalidGoalFilterException::class)
    fun isMatch(goal: GoalModel): Boolean {
        val matchesStatus = statusVisibleMap[goal.status]
        if (matchesStatus == null) {
            throw InvalidGoalFilterException("Goal status not found in statusVisibleMap")
        }
        val matchesPriority = priorityVisibleMap[goal.priority]
        if (matchesPriority == null) {
            throw InvalidGoalFilterException("Goal priority not found in priorityVisibleMap")
        }

        return matchesStatus && matchesPriority && matchesSearchQuery(goal)
    }

    private fun matchesSearchQuery(goal: GoalModel): Boolean {
        return searchQuery.isNullOrBlank() || goal.title.contains(searchQuery, ignoreCase = true)
    }


    override fun toString(): String {
        return """GoalFilter (
                priorityVisibleMap=$priorityVisibleMap,
                statusVisibleMap=$statusVisibleMap
                searchQuery=$searchQuery
                """.trimIndent()
    }
}
