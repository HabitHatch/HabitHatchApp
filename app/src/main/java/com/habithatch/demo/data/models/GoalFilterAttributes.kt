package com.habithatch.demo.data.models

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig


/**
 * Filters goals based on priority and status.
 *
 * @param priorityVisibleMap Maps each priority to its visibility.
 * @param statusVisibleMap Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering goals.
 */
@ConsistentCopyVisibility
data class GoalFilterAttributes private constructor(
    val priorityVisibleMap: Map<GoalModel.Priority, Boolean>,
    val statusVisibleMap: Map<GoalModel.Status, Boolean>,
    val searchQuery: String?,
) {
    public fun builder(): Builder {
        return Builder(this)
    }

    class Builder constructor(
        goalFilterAttributes: GoalFilterAttributes
    ) {
        private var priorityVisibleMap = goalFilterAttributes.priorityVisibleMap
        private var statusVisibleMap = goalFilterAttributes.statusVisibleMap
        private var searchQuery = goalFilterAttributes.searchQuery

        @Inject
        constructor(
            config: HabitHatchConfig
        ) : this(
                GoalFilterAttributes(
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

        fun includePriority(priority: GoalModel.Priority): Builder {
            return setPriority(priority, true)
        }

        fun excludePriority(priority: GoalModel.Priority): Builder {
            return setPriority(priority, false)
        }

        fun setPriority(priority: GoalModel.Priority, visible: Boolean): Builder {
            this.priorityVisibleMap = this.priorityVisibleMap.toMutableMap().apply {
                this[priority] = visible
            }
            return this
        }

        fun setStatus(status: GoalModel.Status, visible: Boolean): Builder {
            this.statusVisibleMap = this.statusVisibleMap.toMutableMap().apply {
                this[status] = visible
            }
            return this
        }

        fun excludeStatus(status: GoalModel.Status): Builder {
            return setStatus(status, false)
        }

        fun includeStatus(status: GoalModel.Status): Builder {
            return setStatus(status, true)
        }

        fun setSearchQuery(searchQuery: String): Builder {
            this.searchQuery = searchQuery
            return this
        }

        fun removeSearchQuery(): Builder {
            this.searchQuery = null
            return this
        }

        fun build(): GoalFilterAttributes {
            return GoalFilterAttributes(
                    priorityVisibleMap = priorityVisibleMap,
                    statusVisibleMap = statusVisibleMap,
                    searchQuery = searchQuery,
            )
        }
    }
}
