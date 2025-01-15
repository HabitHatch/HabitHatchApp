package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import com.habithatch.demo.data.models.HabitModel

typealias PriorityVisibility = Map<HabitModel.Priority, Boolean>
typealias StatusVisibility = Map<HabitModel.Status, Boolean>

/**
 * Filters habits based on priority, statuses and a search query.
 *
 * @param priorityVisibility Maps each priority to its visibility.
 * @param statusVisibility Maps each status to its visibility.
 * @param searchQuery Optional search term for filtering habits.
 */
@Immutable
@ConsistentCopyVisibility
data class HabitFilter private constructor(
    val priorityVisibility: PriorityVisibility,
    val statusVisibility: StatusVisibility,
    val searchQuery: String?,
) {
    /**
     * Builder for [HabitFilter].
     *
     * @param priorityProvider Provides the priorities for habits.
     * @param statusProvider Provides the statuses for habits.
     */
    @ConsistentCopyVisibility
    data class Builder private constructor(
        private val priorityProvider: HabitPriorityProvider,
        private val statusProvider: HabitStatusProvider,
        private val priorityVisibility: PriorityVisibility = mutableMapOf(),
        private val statusVisibility: StatusVisibility = mutableMapOf(),
        private val searchQuery: String? = null,
    ) {
        fun matchAll(): Builder = this.matchAllPriorities().matchAllStatuses()

        fun matchAllPriorities() = this.copy(priorityVisibility = priorityProvider.priorities.associateWith { true })

        fun matchAllStatuses() = this.copy(statusVisibility = statusProvider.statuses.associateWith { true })

        fun matchNoneStatuses() = this.copy(statusVisibility = statusProvider.statuses.associateWith { false })

        fun onlyMatch(status: HabitModel.Status) = this.matchNoneStatuses().includeStatus(status)

        @Suppress("ktlint:standard:function-expression-body")
        fun priorityVisibility(priorityVisibility: PriorityVisibility): Builder {
            return this.copy(priorityVisibility = priorityVisibility)
        }

        fun priorityVisibility(
            priority: HabitModel.Priority,
            visible: Boolean,
        ): Builder =
            this.priorityVisibility(
                this.priorityVisibility + (priority to visible),
            )

        fun setDoneStatusVisibility(visible: Boolean): Builder {
            val doneStatus = statusProvider.statuses.first { it.isDone }
            return statusVisibility(doneStatus, visible)
        }

        fun statusVisibility(statusVisibility: StatusVisibility) = this.copy(statusVisibility = statusVisibility)

        fun statusVisibility(
            status: HabitModel.Status,
            visible: Boolean,
        ): Builder =
            this.statusVisibility(
                this.statusVisibility + (status to visible),
            )

        /**
         * @suppress
         */
        fun includeStatus(status: HabitModel.Status) = statusVisibility(status, true)

        /**
         * @suppress
         */
        fun excludeStatus(status: HabitModel.Status) = statusVisibility(status, false)

        fun setSearchQuery(searchQuery: String?): Builder = this.copy(searchQuery = searchQuery)

        @Throws(IllegalStateException::class)
        fun build(): HabitFilter {
            checkValidity()
            return HabitFilter(
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
             * Creates a [HabitFilter.Builder] that matches all habits.
             *
             * @param priorityProvider Provides the priorities for habits.
             * @param statusProvider Provides the statuses for habits.
             */
            fun matchAllBuilder(
                priorityProvider: HabitPriorityProvider,
                statusProvider: HabitStatusProvider,
            ) = Builder(priorityProvider, statusProvider).matchAll()

            /**
             * Creates a [HabitFilter.Builder] from a [HabitFilter].
             *
             * @param habitFilter The [HabitFilter] to copy.
             * @param priorityProvider Provides the priorities for habits.
             * @param statusProvider Provides the statuses for habits.
             */
            fun createFromFilter(
                habitFilter: HabitFilter,
                priorityProvider: HabitPriorityProvider,
                statusProvider: HabitStatusProvider,
            ) = Builder(priorityProvider, statusProvider)
                .priorityVisibility(habitFilter.priorityVisibility)
                .statusVisibility(habitFilter.statusVisibility)
                .setSearchQuery(habitFilter.searchQuery)
        }
    }

    /**
     * Checks if a habit matches the filter.
     *
     * @param habit The habit to check.
     * @return True if the habit matches the filter, false otherwise.
     */
    @Throws(IllegalArgumentException::class)
    fun isMatch(habit: HabitModel): Boolean = matchesStatus(habit) && matchesPriority(habit) && matchesSearchQuery(habit)

    /**
     * Checks if a done status is visible.
     *
     * @return True if a done status is visible, false otherwise.
     */
    fun isDoneVisible(): Boolean = statusVisibility.entries.any { (status, visible) -> status.isDone && visible }

    @Throws(IllegalArgumentException::class)
    private fun matchesStatus(habit: HabitModel): Boolean {
        require(statusVisibility[habit.status] != null) { "status ${habit.status.label} not in HabitFilter" }
        return statusVisibility[habit.status]!!
    }

    @Throws(IllegalArgumentException::class)
    private fun matchesPriority(habit: HabitModel): Boolean {
        require(priorityVisibility[habit.priority] != null) { "priority ${habit.priority.label} not in HabitFilter" }
        return priorityVisibility[habit.priority]!!
    }

    private fun notHasSearchQuery() = searchQuery.isNullOrBlank()

    @Throws(NullPointerException::class)
    private fun titleContains(habit: HabitModel) = habit.title.contains(searchQuery!!, ignoreCase = true)

    private fun matchesSearchQuery(habit: HabitModel) = notHasSearchQuery() || titleContains(habit)

    /**
     * @suppress
     */
    override fun toString(): String =
        """
        ${this.javaClass.simpleName} (
        ${HabitFilter::priorityVisibility.name}=$priorityVisibility,
        ${HabitFilter::statusVisibility.name}=$statusVisibility
        ${HabitFilter::searchQuery.name}=$searchQuery
        )
        """.trimIndent()
}
