package com.habithatch.demo.common.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.models.GoalFilter

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
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { showDialog.value = true }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Goal")
                }
            },
            content = { paddingValues ->
                Column(
                        modifier = Modifier.padding(paddingValues)
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
                                .padding(paddingValues)
                    )
                }
            }
    )

    if (showDialog.value) {
        AddGoalDialog(
                onDismiss = { showDialog.value = false },
                onAdd = { goalName ->
                    addGoal(goalName)
                    showDialog.value = false
                }
        )
    }
}