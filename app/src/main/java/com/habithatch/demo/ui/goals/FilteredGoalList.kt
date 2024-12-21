package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.models.GoalFilterAttributes
import com.habithatch.demo.data.models.GoalModel

@Composable
fun FilteredGoalList(
    goals: List<GoalModel>,
    modifier: Modifier = Modifier.padding(4.dp).fillMaxWidth(),
    goalFilter: GoalFilterAttributes,
    onToggleGoalStatus: (GoalModel) -> Unit = {},
    onQueryChange: (String) -> Unit = {},
    onGoalStateVisibilityChange: (GoalModel.Status, Boolean) -> Unit = { state, visible -> },
    onPriorityVisibilityChange: (GoalModel.Priority, Boolean) -> Unit = {priority, visible -> },
) {
    Column(
            modifier = modifier
    ) {
        GoalFilterBar(
                priorities = emptyList<GoalModel.Priority>(),
                goalFilter = goalFilter,
                onQueryChange = onQueryChange,
                onGoalStateVisibleChange = onGoalStateVisibilityChange,
                onPriorityVisibilityChange = onPriorityVisibilityChange
        )
        GoalList(
                goals = goals,
                modifier = Modifier.fillMaxSize(),
                onToggleGoalStatus = onToggleGoalStatus,
        )
    }
}