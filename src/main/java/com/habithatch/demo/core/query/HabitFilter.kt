package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import com.habithatch.demo.data.models.HabitModel

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
    /** Builder for [HabitFilter]. */
    @ConsistentCopyVisibility
    data class Builder private constructor(
        val allPriorities: Set<HabitModel.Priority>,
        val allStatuses: Set<HabitModel.Status>,
        private val priorityVisibility: PriorityVisibility = mutableMapOf(),
        private val statusVisibility: StatusVisibility = mutableMapOf(),
        private val searchQuery: String? = null,
    ) {
        private constructor(
            priorityProvider: HabitPriorityProvider,
            statusProvider: HabitStatusProvider,
        ) : this(
            priorityProvider.priorities,
            statusProvider.statuses,
        )

        fun matchAll(): Builder = this.matchAllPriorities().matchAllStatuses()

        fun matchAllPriorities() = this.copy(priorityVisibility = allPriorities.associateWith { true })

        fun matchAllStatuses() = this.copy(statusVisibility = allStatuses.associateWith { true })

        @Suppress("ktlint:standard:function-expression-body")
        fun priorityVisibility(priorityVisibility: PriorityVisibility): Builder {
            return this.copy(priorityVisibility = priorityVisibility)
        }

        @Suppress("ktlint:standard:function-expression-body")
        fun priorityVisibility(
            priority: HabitModel.Priority,
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
            status: HabitModel.Status,
            visible: Boolean,
        ): Builder =
            this.statusVisibility(
                this.statusVisibility + (status to visible),
            )

        /** @suppress */
        fun includeStatus(status: HabitModel.Status) = statusVisibility(status, true)

        /** @suppress*/
        fun excludeStatus(status: HabitModel.Status) = statusVisibility(status, false)

        fun setSearchQuery(searchQuery: String?) = this.copy(searchQuery = searchQuery)

        @Throws(IllegalStateException::class)
        fun build(): HabitFilter {
            checkValid()
            return HabitFilter(
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
            /** Creates a [HabitFilter.Builder] that matches all habits. */
            @Suppress("ktlint:standard:function-expression-body")
            fun matchAllBuilder(
                priorityProvider: HabitPriorityProvider,
                statusProvider: HabitStatusProvider,
            ): Builder {
                return Builder(priorityProvider, statusProvider).matchAll()
            }
        }
    }

    /** Checks if a habit matches the filter. */
    @Throws(IllegalArgumentException::class)
    fun isMatch(habit: HabitModel) = matchesStatus(habit) && matchesPriority(habit) && matchesSearchQuery(habit)

    /**Checks if a done status is visible.*/
    fun isDoneVisible() = statusVisibility.entries.any { (status, visible) -> status.isDone && visible }

    @Throws(IllegalArgumentException::class)
    private fun matchesStatus(habit: HabitModel): Boolean {
        require(statusVisibility[habit.status] != null) { "status id ${habit.status.id} not in HabitFilter" }
        return statusVisibility[habit.status]!!
    }

    @Throws(IllegalArgumentException::class)
    private fun matchesPriority(habit: HabitModel): Boolean {
        require(priorityVisibility[habit.priority] != null) { "priority ${habit.priority.labelRes} not in HabitFilter" }
        return priorityVisibility[habit.priority]!!
    }

    private fun notHasSearchQuery() = searchQuery.isNullOrBlank()

    @Throws(NullPointerException::class)
    private fun titleContains(habit: HabitModel) = habit.title.contains(searchQuery!!, ignoreCase = true)

    private fun matchesSearchQuery(habit: HabitModel) = notHasSearchQuery() || titleContains(habit)

    /** @suppress */
    override fun toString(): String =
        """ ${this.javaClass.simpleName} (
        ${HabitFilter::priorityVisibility.name}=$priorityVisibility,
        ${HabitFilter::statusVisibility.name}=$statusVisibility
        ${HabitFilter::searchQuery.name}=$searchQuery)
        """.trimIndent()
}
