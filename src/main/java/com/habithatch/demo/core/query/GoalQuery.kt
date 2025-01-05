package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.util.disableAll
import com.habithatch.demo.core.util.getUsed
import com.habithatch.demo.core.util.removeByLabel
import com.habithatch.demo.data.models.GoalModel
import javax.inject.Inject

/**
 * Query for filtering and sorting goals.
 *
 * @param filter The filter for the goals.
 * @param sortOptions The sort options for the goals.
 * @param defaultComparator The default comparator for the goals.
 * @param priorityProvider Provides the priorities for goals.
 * @param statusProvider Provides the statuses for goals.
 */
@Immutable
data class GoalQuery(
    val filter: GoalFilter,
    val sortOptions: List<GoalSortOption> = emptyList(),
    val defaultComparator: Comparator<GoalModel>,
    private val priorityProvider: GoalPriorityProvider,
    private val statusProvider: GoalStatusProvider,
) {
    init {
        this.checkValidity()
    }

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(sortOption: GoalSortOption): GoalQuery {
        require(sortOptions.filter { it.label == sortOption.label }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(sortOption)
    }

    fun getComparator() = (getActiveComparator() ?: compareBy { 0 }).then(defaultComparator)

    fun getFilterBuilder() = GoalFilter.Builder.createFromFilter(filter, priorityProvider, statusProvider)

    private fun setActiveSortOption(sortOption: GoalSortOption): GoalQuery {
        val disabledOptions = sortOptions.removeByLabel(sortOption.label).disableAll()
        return this.copy(sortOptions = disabledOptions + sortOption)
    }

    private fun getActiveComparator() = sortOptions.getUsed().firstOrNull()?.comparator

    @Throws(IllegalStateException::class)
    private fun checkValidity() {
        check(sortOptions.getUsed().size <= 1) {
            "There must be no more than one active sortOption"
        }
        check(filter.priorityVisibility.keys == priorityProvider.priorities.toSet()) {
            "Priority visible map must contain all priorities"
        }
        check(filter.statusVisibility.keys == statusProvider.statuses.toSet()) {
            "Status visible map must contain all statuses"
        }
    }

    /**
     * @suppress
     */
    override fun toString(): String =
        """
        GoalQuery(
            filter=$filter,
            sortOptions=$sortOptions,
        )
        """.trimIndent()

    /**
     * Factory for creating [GoalQuery] instances.
     */
    class Factory
        @Inject
        constructor(
            private val priorityProvider: GoalPriorityProvider,
            private val statusProvider: GoalStatusProvider,
        ) {
            fun createGoalQuery(
                filter: GoalFilter,
                sortOptions: List<GoalSortOption> = emptyList(),
                defaultComparator: Comparator<GoalModel> = compareBy { 0 },
            ): GoalQuery =
                GoalQuery(
                    filter = filter,
                    sortOptions = sortOptions,
                    defaultComparator = defaultComparator,
                    priorityProvider = priorityProvider,
                    statusProvider = statusProvider,
                )

            fun createFilterQuery(
                filter: GoalFilter,
            ): GoalQuery = createGoalQuery(filter, emptyList(), compareBy { 0 })
        }
}
