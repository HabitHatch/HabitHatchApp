package com.habithatch.demo.common.goals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalDoneState

@Composable
fun GoalList(
    goals: List<Goal>,
    onToggleDone: (Goal) -> Unit,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(5.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        goals.forEach { goal ->
            item {
                GoalItem(goal = goal, onToggleDone = onToggleDone)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalListPreview() {
    val goals = listOf(
            Goal(title = "Goal 1", isDone = GoalDoneState.DONE),
            Goal(title = "Goal 2"),
            Goal(title = "Goal 3")
    )
    GoalList(goals = goals, onToggleDone = {})
}