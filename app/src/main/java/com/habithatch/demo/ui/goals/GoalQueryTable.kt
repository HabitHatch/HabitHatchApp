package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.util.GoalSortOption
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery

@Composable
fun GoalQueryTable(
    goals: List<GoalModel>,
    allPriorities: List<GoalModel.Priority>,
    allStatuses: List<GoalModel.Status>,
    modifier: Modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth(),
    goalQuery: GoalQuery,
    onToggleGoalStatus: (GoalModel) -> Unit = {},
    onGoalQueryChange: (GoalQuery) -> Unit = {},
) {
    Column(
            modifier = modifier
    ) {
        GoalFilterBar(
                allPriorities = allPriorities,
                allStatuses = allStatuses,
                goalFilter = goalQuery.filter,
                onGoalFilterChange = {
                    val newGoalQuery = goalQuery.updateFilterConfig(it)
                    onGoalQueryChange(newGoalQuery)
                }
        )
        GoalSortBar(
                goalQuery = goalQuery,
                onGoalQueryChange = onGoalQueryChange
        )
        GoalList(
                goals = goals,
                modifier = Modifier.fillMaxSize(),
                onToggleGoalStatus = onToggleGoalStatus,
        )
    }
}