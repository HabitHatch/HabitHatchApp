package com.habithatch.demo.common.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.EnumMap
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.GoalPriority

@Composable
fun FilteredGoalList(
    goals: List<Goal>,
    modifier: Modifier = Modifier.padding(4.dp).fillMaxWidth(),
    searchQuery: String= "",
    visibleDoneStates: EnumMap<GoalStatus, Boolean>,
    visiblePriorities: EnumMap<GoalPriority, Boolean>,
    onToggleGoalStatus: (Goal) -> Unit = {},
    onGoalClicked: (Goal) -> Unit = {},
    onQueryChange: (String) -> Unit = {},
    onDoneStateVisibilityChange: (GoalStatus, Boolean) -> Unit = {state, visible -> },
    onPriorityVisibilityChange: (GoalPriority, Boolean) -> Unit = {priority, visible -> },
) {

    Column(
            modifier = modifier
    ) {
        GoalFilterBar(
                searchQuery = searchQuery,
                visibleDoneStates = visibleDoneStates,
                visiblePriorities = visiblePriorities,
                onQueryChange = onQueryChange,
                onDoneStateVisibleChange = onDoneStateVisibilityChange,
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