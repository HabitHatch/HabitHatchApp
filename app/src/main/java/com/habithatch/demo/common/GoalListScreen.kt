package com.habithatch.demo.common

import com.habithatch.demo.data.entities.Goal
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
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GoalListScreen(
    goals: List<Goal>,
    onAddGoal: (String) -> Unit,
    onToggleDone: (Goal) -> Unit
) {
    var showDialog = remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog.value = true }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Goal")
            }
        },
        content = { paddingValues ->
            GoalList(
                goals = goals,
                onToggleDone = onToggleDone,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            )
        }
    )

    if (showDialog.value) {
        AddGoalDialog(
            onDismiss = { showDialog.value = false },
            onAdd = { goalName ->
                onAddGoal(goalName)
                showDialog.value = false
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGoalListScreen() {
    GoalListScreen(
        goals = listOf(
            Goal(id = 1, title = "Goal 1"),
            Goal(id = 2, title = "Goal 2"),
            Goal(id = 3, title = "Goal 3")
        ),
        onAddGoal = { goalName -> println("Added goal: $goalName") },
        onToggleDone = { goal -> println("Toggled done for goal: ${goal.title}") }
    )
}
