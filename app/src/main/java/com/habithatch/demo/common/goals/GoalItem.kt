package com.habithatch.demo.common.goals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalDoneState

@Composable
fun GoalItem(
    goal: Goal,
    onToggleDone: (Goal) -> Unit
) {
    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(
                    containerColor =
                    if (goal.isDone == GoalDoneState.DONE)
                        MaterialTheme.colorScheme.secondaryContainer
                    else
                        MaterialTheme.colorScheme.primaryContainer
            )
    ) {
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                    checked = goal.isDone == GoalDoneState.DONE,
                    onCheckedChange = { onToggleDone(goal) },
                    modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                    text = goal.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                            textDecoration =
                            if (goal.isDone == GoalDoneState.DONE)
                                TextDecoration.LineThrough
                            else TextDecoration.None,

                            color =
                            if (goal.isDone == GoalDoneState.DONE)
                                MaterialTheme.colorScheme.onSecondaryContainer
                            else
                                MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GoalItemPreview() {
    Column {
        GoalItem(
                goal = Goal(title = "Test Goal"),
                onToggleDone = {}
        )
        GoalItem(
                goal = Goal(title = "Test Goal 2", isDone = GoalDoneState.DONE),
                onToggleDone = {}
        )
    }
}