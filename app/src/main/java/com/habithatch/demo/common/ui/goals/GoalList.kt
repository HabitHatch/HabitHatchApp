package com.habithatch.demo.common.ui.goals

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus

@Composable
fun GoalList(
    goals: List<Goal>,
    modifier: Modifier = Modifier.fillMaxSize(),
    contentPadding: PaddingValues = PaddingValues(4.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.spacedBy(8.dp),
    onToggleGoalStatus: (Goal) -> Unit = {},
    onGoalClicked: (Goal) -> Unit = {},
) {
    LazyColumn(
            modifier = modifier,
            contentPadding = contentPadding,
            verticalArrangement = verticalArrangement
    ) {
        goals.forEach { goal ->
            item {
                GoalItem(
                        goal = goal,
                        onToggleGoalStatus = { onToggleGoalStatus(goal) },
                        onGoalClicked = { onGoalClicked(goal) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalListPreview() {
    val goals = listOf(
            Goal(title = "Done Goal", doneState = GoalStatus.DONE),
            Goal(title = "Undone Goal", doneState = GoalStatus.UNDONE),
            Goal(
                    title = "Important Done Goal",
                    doneState = GoalStatus.DONE,
                    priority = GoalPriority.HIGH
            ),
            Goal(
                    title = "Important Undone Goal",
                    doneState = GoalStatus.UNDONE,
                    priority = GoalPriority.HIGH
            ),
    )
    GoalList(goals = goals)
}