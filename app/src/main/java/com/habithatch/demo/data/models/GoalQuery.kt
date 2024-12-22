package com.habithatch.demo.data.models

import com.habithatch.demo.core.util.GoalSortOption
import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.core.util.SortState

data class GoalQuery(
    val filter: GoalFilter,
    val sortOptions: List<GoalSortOption>,
    val defaultSortConfig: SortConfig<GoalModel>
) {
    fun updateFilterConfig(newFilterConfig: GoalFilter): GoalQuery {
        return this.copy(filter = newFilterConfig)
    }

    fun updateSortOption(selectedOption: GoalSortOption): GoalQuery {
        if (sortOptions.filter { it == selectedOption }.size != 1) {
            throw IllegalArgumentException(
                    "Selected option is not exactly once in the list of sort options"
            )
        }
        val updatedOptions = sortOptions.map { option ->
            if (option == selectedOption) {
                option.cycleState()
            } else {
                option.copy(sortState = SortState.NOT_USED)
            }
        }
        return this.copy(sortOptions = updatedOptions)
    }

    fun getComparator(): Comparator<GoalModel> {
        val sortConfig = sortOptions
            .firstOrNull { it.sortState != SortState.NOT_USED }
            ?.toSortConfig()
            ?: defaultSortConfig
        return sortConfig.getEffectiveComparator().thenBy { it.title.lowercase() }
    }

    override fun toString(): String {
        return """
            GoalQuery(
                filter=$filter,
                sortOptions=$sortOptions,
                defaultSortConfig=$defaultSortConfig
            )
        """.trimIndent()
    }
}
