package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.util.GoalSortOptionState
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery

@Composable
fun GoalQueryTable(
    goals: List<GoalModel>,
    goalSortOptionStates: List<GoalSortOptionState>,
    priorities: List<GoalModel.Priority>,
    modifier: Modifier = Modifier.padding(4.dp).fillMaxWidth(),
    goalQuery: GoalQuery,
    onToggleGoalStatus: (GoalModel) -> Unit = {},
    onGoalClicked: (GoalModel) -> Unit = {},
    onQueryChange: (String) -> Unit = {},
    onGoalStateVisibilityChange: (GoalModel.Status, Boolean) -> Unit = { state, visible -> },
    onPriorityVisibilityChange: (GoalModel.Priority, Boolean) -> Unit = { priority, visible -> },
    sortOptionStateClicked: (GoalSortOptionState) -> Unit = {}
) {
    Column(
            modifier = modifier
    ) {
        GoalFilterBar(
                priorities = priorities,
                goalFilter = goalQuery.filterAttributes,
                onQueryChange = onQueryChange,
                onGoalStateVisibleChange = onGoalStateVisibilityChange,
                onPriorityVisibilityChange = onPriorityVisibilityChange
        )
        GoalSortBar(
                goalSortOptionStates = goalSortOptionStates,
                sortOptionStateClicked = sortOptionStateClicked
        )
        GoalList(
                goals = goals,
                modifier = Modifier.fillMaxSize(),
                onToggleGoalStatus = onToggleGoalStatus,
                onGoalClicked = onGoalClicked
        )
    }
}