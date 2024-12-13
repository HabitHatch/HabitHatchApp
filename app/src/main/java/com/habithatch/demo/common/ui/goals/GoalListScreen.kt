package com.habithatch.demo.common.ui.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority

@Composable
fun GoalListScreen(
    goals: List<Goal>,
    searchQuery: String,
    visibleDoneStates: Map<GoalDoneState, Boolean>,
    visiblePriorities: Map<GoalPriority, Boolean>,
    onToggleDone: (Goal) -> Unit,
    addGoal: (String) -> Unit,
    onQueryChange: (String) -> Unit,
    onDoneStateVisibilityChange: (GoalDoneState, Boolean) -> Unit,
    onPriorityVisibilityChange: (GoalPriority, Boolean) -> Unit,
) {

    Column(
            modifier = Modifier.padding(4.dp)
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
                onToggleDone = onToggleDone,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
        )
    }
}