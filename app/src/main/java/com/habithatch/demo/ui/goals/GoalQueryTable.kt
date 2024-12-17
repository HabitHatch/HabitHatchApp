package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.models.GoalFilterAttributes
import com.habithatch.demo.data.models.GoalQuery

@Composable
fun GoalQueryTable(
    goals: List<Goal>,
    modifier: Modifier = Modifier.padding(4.dp).fillMaxWidth(),
    goalQuery: GoalQuery,
    onToggleGoalStatus: (Goal) -> Unit = {},
    onGoalClicked: (Goal) -> Unit = {},
    onQueryChange: (String) -> Unit = {},
    onGoalStateVisibilityChange: (GoalStatus, Boolean) -> Unit = { state, visible -> },
    onPriorityVisibilityChange: (GoalPriority, Boolean) -> Unit = {priority, visible -> },
) {
    Column(
            modifier = modifier
    ) {
        GoalFilterBar(
                goalFilterAttributes = goalQuery.filterConfig,
                onQueryChange = onQueryChange,
                onGoalStateVisibleChange = onGoalStateVisibilityChange,
                onPriorityVisibilityChange = onPriorityVisibilityChange
        )
        GoalList(
                goals = goals,
                modifier = Modifier.fillMaxSize(),
                onToggleGoalStatus = onToggleGoalStatus,
                onGoalClicked = onGoalClicked
        )
    }
}