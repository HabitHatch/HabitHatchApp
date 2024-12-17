package com.habithatch.demo.data.models

import com.habithatch.demo.core.util.SortConfig
import com.habithatch.demo.data.entities.Goal

data class GoalQuery(
    val filterConfig : GoalFilterAttributes,
    val sortConfig: SortConfig<Goal>
){
    fun updateFilterConfig(newFilterConfig: GoalFilterAttributes): GoalQuery {
        return GoalQuery(newFilterConfig, sortConfig)
    }

    fun updateSortConfig(newSortConfig: SortConfig<Goal>): GoalQuery {
        return GoalQuery(filterConfig, newSortConfig)
    }
}