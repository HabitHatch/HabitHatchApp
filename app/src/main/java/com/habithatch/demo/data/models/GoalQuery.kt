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
        val updatedOptions = sortOptions.map { option ->
            if (option == selectedOption) {
                option.apply { cycleState() }
            } else {
                option.apply { sortState = SortState.NOT_USED }
            }
        }
        return this.copy(sortOptions = updatedOptions)
    }

    fun getSortConfig(): SortConfig<GoalModel> {
        return sortOptions
            .firstOrNull { it.sortState != SortState.NOT_USED }
            ?.toSortConfig()
            ?: defaultSortConfig
    }
}
