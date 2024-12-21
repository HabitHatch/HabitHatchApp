package com.habithatch.demo.data.models

import com.habithatch.demo.core.util.SortConfig

data class GoalQuery(
    val filterAttributes : GoalFilterAttributes,
    val sortConfig: SortConfig<GoalModel>
){
    fun updateFilterConfig(newFilterConfig: GoalFilterAttributes): GoalQuery {
        return GoalQuery(newFilterConfig, sortConfig)
    }

    fun updateSortConfig(newSortConfig: SortConfig<GoalModel>): GoalQuery {
        return GoalQuery(filterAttributes, newSortConfig)
    }
}