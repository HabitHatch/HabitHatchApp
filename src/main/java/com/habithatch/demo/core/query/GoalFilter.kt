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
    /**
     * Builder for [GoalFilter].
     *
     * @param priorityProvider Provides the priorities for goals.
     * @param statusProvider Provides the statuses for goals.
     */
    @ConsistentCopyVisibility
    data class Builder private constructor(
        private val priorityProvider: GoalPriorityProvider,
        private val statusProvider: GoalStatusProvider,
        private val priorityVisibility: PriorityVisibility = mutableMapOf(),
        private val statusVisibility: StatusVisibility = mutableMapOf(),
        private val searchQuery: String? = null,
    ) {
        fun matchAll(): Builder = this.matchAllPriorities().matchAllStatuses()

        fun matchAllPriorities() = this.copy(priorityVisibility = priorityProvider.priorities.associateWith { true })

        fun matchAllStatuses() = this.copy(statusVisibility = statusProvider.statuses.associateWith { true })

        fun matchNoneStatuses() = this.copy(statusVisibility = statusProvider.statuses.associateWith { false })

        fun onlyMatch(status: GoalModel.Status) = this.matchNoneStatuses().includeStatus(status)

        @Suppress("ktlint:standard:function-expression-body")
        fun setPriorityVisibility(priorityVisibility: PriorityVisibility): Builder {
            return this.copy(priorityVisibility = priorityVisibility)
        }

        fun statusVisibility(statusVisibility: StatusVisibility) = this.copy(statusVisibility = statusVisibility)

        fun setPriorityVisibility(
            priority: GoalModel.Priority,
            visible: Boolean,
        ): Builder =
            this.setPriorityVisibility(
                this.priorityVisibility + (priority to visible),
            )

        fun setDoneStatusVisibility(visible: Boolean): Builder {
            val doneStatus = statusProvider.statuses.first { it.isDone }
            return statusVisibility(doneStatus, visible)
        }

        fun statusVisibility(
            status: GoalModel.Status,
            visible: Boolean,
        ): Builder =
            this.statusVisibility(
                this.statusVisibility + (status to visible),
            )

        fun includeStatus(status: GoalModel.Status) = statusVisibility(status, true)

        fun excludeStatus(status: GoalModel.Status) = statusVisibility(status, false)

        fun setSearchQuery(searchQuery: String?): Builder = this.copy(searchQuery = searchQuery)

        @Throws(IllegalStateException::class)
        fun build(): GoalFilter {
            checkValidity()
            return GoalFilter(
                priorityVisibility = priorityVisibility,
                statusVisibility = statusVisibility,
                searchQuery = searchQuery,
            )
        }

        @Throws(IllegalStateException::class)
        private fun checkValidity() {
            check(statusVisibility.keys == statusProvider.statuses) {
                "Status visible map must contain all statuses"
            }

            check(priorityVisibility.keys == priorityProvider.priorities) {
                "Priority visible map must contain all priorities"
            }
        }

        companion object {
            /**
             * Creates a [GoalFilter.Builder] that matches all goals.
             *
             * @param priorityProvider Provides the priorities for goals.
             * @param statusProvider Provides the statuses for goals.
             */
            fun matchAllBuilder(
                priorityProvider: GoalPriorityProvider,
                statusProvider: GoalStatusProvider,
            ) = Builder(priorityProvider, statusProvider).matchAll()

            /**
             * Creates a [GoalFilter.Builder] from a [GoalFilter].
             *
             * @param goalFilter The [GoalFilter] to copy.
             * @param priorityProvider Provides the priorities for goals.
             * @param statusProvider Provides the statuses for goals.
             */
            fun createFromFilter(
                goalFilter: GoalFilter,
                priorityProvider: GoalPriorityProvider,
                statusProvider: GoalStatusProvider,
            ) = Builder(priorityProvider, statusProvider)
                .setPriorityVisibility(goalFilter.priorityVisibility)
                .statusVisibility(goalFilter.statusVisibility)
                .setSearchQuery(goalFilter.searchQuery)
        }
    }

    /**
     * Checks if a goal matches the filter.
     *
     * @param goal The goal to check.
     * @return True if the goal matches the filter, false otherwise.
     */
    @Throws(IllegalArgumentException::class)
    fun isMatch(goal: GoalModel): Boolean = matchesStatus(goal) && matchesPriority(goal) && matchesSearchQuery(goal)

    /**
     * Checks if a done status is visible.
     *
     * @return True if a done status is visible, false otherwise.
     */
    fun isDoneVisible(): Boolean = statusVisibility.entries.any { (status, visible) -> status.isDone && visible }

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

    override fun toString(): String =
        """
        ${this.javaClass.simpleName} (
        ${GoalFilter::priorityVisibility.name}=$priorityVisibility,
        ${GoalFilter::statusVisibility.name}=$statusVisibility
        ${GoalFilter::searchQuery.name}=$searchQuery
        )
        """.trimIndent()
}
