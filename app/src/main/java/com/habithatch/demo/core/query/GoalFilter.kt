package com.habithatch.demo.core.query

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.exceptions.InvalidGoalFilterException
import com.habithatch.demo.data.models.GoalModel

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
    class Builder {
        private var priorityVisibleMap: Map<GoalModel.Priority, Boolean>
        private var statusVisibleMap: Map<GoalModel.Status, Boolean>
        private var searchQuery: String?
        private val priorityProvider: GoalPriorityProvider
        private val statusProvider: GoalStatusProvider

        private constructor(
            priorityProvider: GoalPriorityProvider,
            statusProvider: GoalStatusProvider,
        ) {
            this.priorityProvider = priorityProvider
            this.statusProvider = statusProvider
            this.priorityVisibleMap = priorityProvider.priorities.associateWith { false }
            this.statusVisibleMap = statusProvider.statuses.associateWith { false }
            this.searchQuery = null
        }

        fun setMatchAll(): Builder {
            this.priorityVisibleMap = this.priorityVisibleMap.keys.associateWith { true }
            this.statusVisibleMap = this.statusVisibleMap.keys.associateWith { true }
            return this
        }

        fun setPriorityVisibleMap(priorityVisibleMap: Map<GoalModel.Priority, Boolean>): Builder {
            this.priorityVisibleMap = priorityVisibleMap
            checkValidity()
            return this
        }

        fun setStatusVisibleMap(statusVisibleMap: Map<GoalModel.Status, Boolean>): Builder {
            this.statusVisibleMap = statusVisibleMap
            checkValidity()
            return this
        }

        fun setPriorityVisibility(
            priority: GoalModel.Priority,
            visible: Boolean,
        ): Builder {
            this.setPriorityVisibleMap(
                this.priorityVisibleMap.toMutableMap().apply {
                    this[priority] = visible
                },
            )
            return this
        }

        fun setStatusVisibility(
            status: GoalModel.Status,
            visible: Boolean,
        ): Builder {
            this.setStatusVisibleMap(
                this.statusVisibleMap.toMutableMap().apply {
                    this[status] = visible
                },
            )
            return this
        }

        fun excludeStatus(status: GoalModel.Status): Builder = setStatusVisibility(status, false)

        fun setSearchQuery(searchQuery: String?): Builder {
            this.searchQuery = searchQuery
            return this
        }

        @Throws(InvalidGoalFilterException::class)
        fun build(): GoalFilter {
            checkValidity()
            return GoalFilter(
                priorityVisibleMap = priorityVisibleMap,
                statusVisibleMap = statusVisibleMap,
                searchQuery = searchQuery,
            )
        }

        @Throws(InvalidGoalFilterException::class)
        private fun checkValidity() {
            if (statusVisibleMap.keys != statusProvider.statuses.toSet()) {
                throw InvalidGoalFilterException("Status visible map must contain all statuses")
            }

            if (priorityVisibleMap.keys != priorityProvider.priorities.toSet()) {
                throw InvalidGoalFilterException("Priority visible map must contain all priorities")
            }
        }

        companion object {
            fun createMatchAllBuilder(
                priorityProvider: GoalPriorityProvider,
                statusProvider: GoalStatusProvider,
            ): Builder = Builder(priorityProvider, statusProvider).setMatchAll()

            fun createFromFilter(
                goalFilter: GoalFilter,
                priorityProvider: GoalPriorityProvider,
                statusProvider: GoalStatusProvider,
            ): Builder =
                Builder(priorityProvider, statusProvider)
                    .setPriorityVisibleMap(goalFilter.priorityVisibleMap)
                    .setStatusVisibleMap(goalFilter.statusVisibleMap)
                    .setSearchQuery(goalFilter.searchQuery)
        }
    }

    @Throws(InvalidGoalFilterException::class)
    fun isMatch(goal: GoalModel): Boolean {
        val matchesStatus =
            statusVisibleMap[goal.status]
                ?: throw InvalidGoalFilterException("Goal status not found in statusVisibleMap")

        val matchesPriority =
            priorityVisibleMap[goal.priority]
                ?: throw InvalidGoalFilterException("Goal priority not found in priorityVisibleMap")

        return matchesStatus && matchesPriority && matchesSearchQuery(goal)
    }

    private fun matchesSearchQuery(goal: GoalModel): Boolean = searchQuery.isNullOrBlank() || goal.title.contains(searchQuery, ignoreCase = true)

    override fun toString(): String =
        """
        GoalFilter (
        priorityVisibleMap=$priorityVisibleMap,
        statusVisibleMap=$statusVisibleMap
        searchQuery=$searchQuery
        """.trimIndent()
}
