package com.habithatch.demo.core.query

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.models.GoalModel

data class GoalQuery constructor(
    val filter: GoalFilter,
    val sortOptions: List<GoalSortOption>,
    val defaultComparator: Comparator<GoalModel>,
    private val priorityProvider: GoalPriorityProvider,
    private val statusProvider: GoalStatusProvider,
) {
    init {
        this.checkValidity()
    }

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun copy(sortOption: GoalSortOption): GoalQuery {
        require(sortOptions.filter { it.label == sortOption.label }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(sortOption)
    }

    fun getComparator(): Comparator<GoalModel> {
        val activeSortOption = getActiveSortOption()

        if (activeSortOption != null) {
            return activeSortOption.getComparator().then(defaultComparator)
        }
        return defaultComparator
    }

    fun getFilterBuilder(): GoalFilter.Builder = GoalFilter.Builder.createFromFilter(filter, priorityProvider, statusProvider)

    private fun setActiveSortOption(sortOption: GoalSortOption): GoalQuery {
        val updatedOptions =
            sortOptions.map { option ->
                if (option.label == sortOption.label) {
                    sortOption
                } else {
                    option.copy(sortState = SortState.NOT_USED)
                }
            }
        return this.copy(sortOptions = updatedOptions)
    }

    private fun getActiveSortOption(): GoalSortOption? = sortOptions.firstOrNull { it.sortState != SortState.NOT_USED }

    @Throws(IllegalStateException::class)
    private fun checkValidity() {
        check(sortOptions.filter { it.sortState != SortState.NOT_USED }.size <= 1) {
            "There must be no more than one active sortOption"
        }
        check(sortOptions.toSet().size == sortOptions.size) {
            "Sort options must be unique"
        }
        check(filter.priorityVisibleMap.keys == priorityProvider.priorities.toSet()) {
            "Priority visible map must contain all priorities"
        }
        check(filter.statusVisibleMap.keys == statusProvider.statuses.toSet()) {
            "Status visible map must contain all statuses"
        }
    }

    override fun toString(): String =
        """
        GoalQuery(
            filter=$filter,
            sortOptions=$sortOptions,
        )
        """.trimIndent()
}
