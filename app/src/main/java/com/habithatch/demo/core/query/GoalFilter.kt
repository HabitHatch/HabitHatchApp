package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.models.GoalModel

typealias PriorityVisibility = Map<GoalModel.Priority, Boolean>
typealias StatusVisibility = Map<GoalModel.Status, Boolean>

/**
 * Filters goals based on priority and status.
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
    @ConsistentCopyVisibility
    data class Builder private constructor(
        private val priorityProvider: GoalPriorityProvider,
        private val statusProvider: GoalStatusProvider,
        private val priorityVisibility: PriorityVisibility = mutableMapOf(),
        private val statusVisibility: StatusVisibility = mutableMapOf(),
        private val searchQuery: String? = null,
    ) {
        fun setMatchAll(): Builder =
            this.copy(
                priorityVisibility = priorityVisibility.keys.associateWith { true },
                statusVisibility = statusVisibility.keys.associateWith { true },
            )

        @Suppress("ktlint:standard:function-expression-body")
        fun setPriorityVisibility(priorityVisibility: PriorityVisibility): Builder {
            return this.copy(priorityVisibility = priorityVisibility)
        }

        fun setStatusVisibility(statusVisibility: StatusVisibility) = this.copy(statusVisibility = statusVisibility)

        fun setPriorityVisibility(
            priority: GoalModel.Priority,
            visible: Boolean,
        ): Builder =
            this.setPriorityVisibility(
                this.priorityVisibility + (priority to visible),
            )

        fun setDoneStatusVisibility(visible: Boolean): Builder {
            val doneStatus = statusProvider.statuses.first { it.isDone }
            return setStatusVisibility(doneStatus, visible)
        }

        fun setStatusVisibility(
            status: GoalModel.Status,
            visible: Boolean,
        ): Builder =
            this.setStatusVisibility(
                this.statusVisibility + (status to visible),
            )

        fun excludeStatus(status: GoalModel.Status) = setStatusVisibility(status, false)

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
                    .setPriorityVisibility(goalFilter.priorityVisibility)
                    .setStatusVisibility(goalFilter.statusVisibility)
                    .setSearchQuery(goalFilter.searchQuery)
        }
    }

    @Throws(IllegalArgumentException::class)
    fun isMatch(goal: GoalModel): Boolean = matchesStatus(goal) && matchesPriority(goal) && matchesSearchQuery(goal)

    @Throws(IllegalArgumentException::class)
    fun matchesStatus(goal: GoalModel): Boolean {
        require(statusVisibility[goal.status] != null) { "status ${goal.status.label} not in GoalFilter" }
        return statusVisibility[goal.status]!!
    }

    @Throws(IllegalArgumentException::class)
    fun matchesPriority(goal: GoalModel): Boolean {
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
