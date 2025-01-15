package com.habithatch.demo.core.query

import androidx.compose.runtime.Immutable
import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import com.habithatch.demo.core.util.disableAll
import com.habithatch.demo.core.util.getUsed
import com.habithatch.demo.core.util.removeByLabel
import com.habithatch.demo.data.models.HabitModel
import javax.inject.Inject

/**
 * Query for filtering and sorting habits.
 *
 * @param filter The filter for the habits.
 * @param sortOptions The sort options for the habits.
 * @param defaultComparator The default comparator for the habits.
 * @param priorityProvider Provides the priorities for habits.
 * @param statusProvider Provides the statuses for habits.
 */
@Immutable
data class HabitQuery(
    val filter: HabitFilter,
    val sortOptions: List<HabitSortOption> = emptyList(),
    val defaultComparator: Comparator<HabitModel>,
    private val priorityProvider: HabitPriorityProvider,
    private val statusProvider: HabitStatusProvider,
) {
    init {
        this.checkValidity()
    }

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(sortOption: HabitSortOption): HabitQuery {
        require(sortOptions.filter { it.label == sortOption.label }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(sortOption)
    }

    fun getComparator() = (getActiveComparator() ?: compareBy { 0 }).then(defaultComparator)

    fun getFilterBuilder() = HabitFilter.Builder.createFromFilter(filter, priorityProvider, statusProvider)

    private fun setActiveSortOption(sortOption: HabitSortOption): HabitQuery {
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
        HabitQuery(
            filter=$filter,
            sortOptions=$sortOptions,
        )
        """.trimIndent()

    /**
     * Factory for creating [HabitQuery] instances.
     */
    class Factory
        @Inject
        constructor(
            private val priorityProvider: HabitPriorityProvider,
            private val statusProvider: HabitStatusProvider,
        ) {
            fun createHabitQuery(
                filter: HabitFilter,
                sortOptions: List<HabitSortOption> = emptyList(),
                defaultComparator: Comparator<HabitModel> = compareBy { 0 },
            ): HabitQuery =
                HabitQuery(
                    filter = filter,
                    sortOptions = sortOptions,
                    defaultComparator = defaultComparator,
                    priorityProvider = priorityProvider,
                    statusProvider = statusProvider,
                )

            fun createFilterQuery(
                filter: HabitFilter,
            ): HabitQuery = createHabitQuery(filter, emptyList(), compareBy { 0 })
        }
}
