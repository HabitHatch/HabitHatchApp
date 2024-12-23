package com.habithatch.demo.core.query

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.models.GoalModel

data class GoalQuery(
    val filter: GoalFilter,
    val sortOptions: List<GoalSortOption>,
    val defaultComparator: Comparator<GoalModel>,
    private val priorityProvider: GoalPriorityProvider,
    private val statusProvider: GoalStatusProvider,
) {
    init {
        this.checkValidity()
    }

    fun updateFilterConfig(newFilterConfig: GoalFilter): GoalQuery = this.copy(filter = newFilterConfig)

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(option: GoalSortOption): GoalQuery {
        require(sortOptions.filter { it.label == option.label }.size == 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        return setActiveSortOption(option)
    }

    fun getComparator(): Comparator<GoalModel> {
        if (getActiveSortOption() != null) {
            return getActiveSortOption()!!.getComparator().then(defaultComparator)
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

    private fun checkValidity() {
        require(sortOptions.filter { it.sortState != SortState.NOT_USED }.size <= 1) {
            "There must be no more than one active sortOption"
        }
        require(sortOptions.toSet().size == sortOptions.size) {
            "Sort options must be unique"
        }
        require(filter.priorityVisibleMap.keys == priorityProvider.priorities.toSet()) {
            "Priority visible map must contain all priorities"
        }
        require(filter.statusVisibleMap.keys == statusProvider.statuses.toSet()) {
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
