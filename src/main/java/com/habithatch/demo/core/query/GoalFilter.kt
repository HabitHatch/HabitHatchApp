package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.models.GoalModel

typealias PriorityVisibility = Map<GoalModel.Priority, Boolean>
typealias StatusVisibility = Map<GoalModel.Status, Boolean>

/**
 * Filters goals based on priority, statuses and a search query.
 *
 * @param priorityVisibility Maps each priority to its visibility.
 * @param statusVisibility Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering goals.
 */
@Immutable
@ConsistentCopyVisibility
data class GoalFilter private constructor(
    val priorityVisibility: PriorityVisibility,
    val statusVisibility: StatusVisibility,
    val searchQuery: String?,
) {
    /** Builder for [GoalFilter]. */
    @ConsistentCopyVisibility
    data class Builder private constructor(
        val allPriorities: Set<GoalModel.Priority>,
        val allStatuses: Set<GoalModel.Status>,
        private val priorityVisibility: PriorityVisibility = mutableMapOf(),
        private val statusVisibility: StatusVisibility = mutableMapOf(),
        private val searchQuery: String? = null,
    ) {
        private constructor(
            priorityProvider: GoalPriorityProvider,
            statusProvider: GoalStatusProvider,
        ) : this(
            priorityProvider.priorities,
            statusProvider.statuses,
        )

        fun matchAll(): Builder = this.matchAllPriorities().matchAllStatuses()

        fun matchAllPriorities() = this.copy(priorityVisibility = allPriorities.associateWith { true })

        fun matchAllStatuses() = this.copy(statusVisibility = allStatuses.associateWith { true })

        fun matchNoneStatuses() = this.copy(statusVisibility = allStatuses.associateWith { false })

        fun onlyMatch(status: GoalModel.Status) = this.matchNoneStatuses().includeStatus(status)

        @Suppress("ktlint:standard:function-expression-body")
        fun priorityVisibility(priorityVisibility: PriorityVisibility): Builder {
            return this.copy(priorityVisibility = priorityVisibility)
        }

        @Suppress("ktlint:standard:function-expression-body")
        fun priorityVisibility(
            priority: GoalModel.Priority,
            visible: Boolean,
        ): Builder {
            return this.priorityVisibility(
                this.priorityVisibility + (priority to visible),
            )
        }

        fun setDoneStatusVisibility(visible: Boolean): Builder {
            val doneStatus = allStatuses.first { it.isDone }
            return statusVisibility(doneStatus, visible)
        }

        fun statusVisibility(statusVisibility: StatusVisibility) = this.copy(statusVisibility = statusVisibility)

        fun statusVisibility(
            status: GoalModel.Status,
            visible: Boolean,
        ): Builder =
            this.statusVisibility(
                this.statusVisibility + (status to visible),
            )

        /** @suppress */
        fun includeStatus(status: GoalModel.Status) = statusVisibility(status, true)

        /** @suppress*/
        fun excludeStatus(status: GoalModel.Status) = statusVisibility(status, false)

        fun setSearchQuery(searchQuery: String?) = this.copy(searchQuery = searchQuery)

        @Throws(IllegalStateException::class)
        fun build(): GoalFilter {
            checkValid()
            return GoalFilter(
                priorityVisibility = priorityVisibility,
                statusVisibility = statusVisibility,
                searchQuery = searchQuery,
            )
        }

        @Throws(IllegalStateException::class)
        private fun checkValid() {
            check(statusVisibility.keys == allStatuses) { "Status visible map must contain all statuses" }

            check(priorityVisibility.keys == allPriorities) { "Priority visible map must contain all priorities" }
        }

        companion object {
            /** Creates a [GoalFilter.Builder] that matches all goals. */
            @Suppress("ktlint:standard:function-expression-body")
            fun matchAllBuilder(
                priorityProvider: GoalPriorityProvider,
                statusProvider: GoalStatusProvider,
            ): Builder {
                return Builder(priorityProvider, statusProvider).matchAll()
            }
        }
    }

    /** Checks if a goal matches the filter. */
    @Throws(IllegalArgumentException::class)
    fun isMatch(goal: GoalModel) = matchesStatus(goal) && matchesPriority(goal) && matchesSearchQuery(goal)

    /**Checks if a done status is visible.*/
    fun isDoneVisible() = statusVisibility.entries.any { (status, visible) -> status.isDone && visible }

    @Throws(IllegalArgumentException::class)
    private fun matchesStatus(goal: GoalModel): Boolean {
        require(statusVisibility[goal.status] != null) { "status ${goal.status.label} not in GoalFilter" }
        return statusVisibility[goal.status]!!
    }

    @Throws(IllegalArgumentException::class)
    private fun matchesPriority(goal: GoalModel): Boolean {
        require(priorityVisibility[goal.priority] != null) { "priority ${goal.priority.label} not in GoalFilter" }
        return priorityVisibility[goal.priority]!!
    }

    private fun notHasSearchQuery() = searchQuery.isNullOrBlank()

    @Throws(NullPointerException::class)
    private fun titleContains(goal: GoalModel) = goal.title.contains(searchQuery!!, ignoreCase = true)

    private fun matchesSearchQuery(goal: GoalModel) = notHasSearchQuery() || titleContains(goal)

    /** @suppress */
    override fun toString(): String =
        """ ${this.javaClass.simpleName} (
        ${GoalFilter::priorityVisibility.name}=$priorityVisibility,
        ${GoalFilter::statusVisibility.name}=$statusVisibility
        ${GoalFilter::searchQuery.name}=$searchQuery)
        """.trimIndent()
}
