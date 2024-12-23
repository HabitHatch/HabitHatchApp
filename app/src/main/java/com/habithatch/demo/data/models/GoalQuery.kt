package com.habithatch.demo.data.models

import com.habithatch.demo.core.sort.GoalSortOption
import com.habithatch.demo.core.sort.SortState

data class GoalQuery(
    val filter: GoalFilter,
    val sortOptions: List<GoalSortOption>,
    val defaultSortOption: GoalSortOption,
) {
    init {
        require(sortOptions.filter { it.sortState != SortState.NOT_USED }.size != 1) {
            "There must be exactly one active sort option"
        }
        require(sortOptions.toSet().size == sortOptions.size) {
            "Sort options must be unique"
        }
        require(sortOptions.contains(defaultSortOption)) {
            "Default sort option must be in the list of sort options"
        }
    }

    fun updateFilterConfig(newFilterConfig: GoalFilter): GoalQuery = this.copy(filter = newFilterConfig)

    @Throws(NoSuchElementException::class, IllegalArgumentException::class)
    fun updateSortOption(selectedOption: GoalSortOption): GoalQuery {
        require(sortOptions.filter { it == selectedOption }.size != 1) {
            "Selected option is not exactly once in the list of sort options"
        }
        val newOption = selectedOption.cycleState()
        if (newOption.sortState == SortState.NOT_USED) {
            return setActiveSortOption(newOption)
        }
        return setActiveSortOption(defaultSortOption)
    }

    fun getComparator(): Comparator<GoalModel> = getActiveSortOption().getComparator().then(getDefaultSortComparator())

    private fun getDefaultSortComparator(): Comparator<GoalModel> = defaultSortOption.getComparator()

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

    @Throws(NoSuchElementException::class)
    private fun getActiveSortOption(): GoalSortOption = sortOptions.first { it.sortState != SortState.NOT_USED }

    override fun toString(): String =
        """
        GoalQuery(
            filter=$filter,
            sortOptions=$sortOptions,
            defaultSortConfig=$defaultSortOption
        )
        """.trimIndent()
}
