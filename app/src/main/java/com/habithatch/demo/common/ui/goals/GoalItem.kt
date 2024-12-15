package com.habithatch.demo.common.ui.goals

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus

@Composable
fun GoalItem(
    goal: Goal,
    rowPadding: PaddingValues = PaddingValues(8.dp),
    checkBoxPadding: PaddingValues = PaddingValues(end = 8.dp),
    onToggleGoalStatus: () -> Unit = {},
    onGoalClicked: () -> Unit = {}
) {
    val cardShape = MaterialTheme.shapes.medium
    Card(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                        if (goal.priority == GoalPriority.HIGH) {
                            Modifier.border(
                                    width = 1.dp,
                                    color = goal.priority.getColor(),
                                    shape = cardShape
                            )
                        } else {
                            Modifier
                        }
                )
                .clickable(onClick = onGoalClicked),
            colors = CardDefaults.cardColors(
                    containerColor = when (goal.status) {
                        GoalStatus.DONE -> MaterialTheme.colorScheme.secondaryContainer
                        GoalStatus.UNDONE -> MaterialTheme.colorScheme.primaryContainer
                    },
            ),
            shape = cardShape
    ) {
        Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(rowPadding),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                    checked = goal.status == GoalStatus.DONE,
                    onCheckedChange = {onToggleGoalStatus()},
                    modifier = Modifier.padding(checkBoxPadding)
            )

            Text(
                    text = goal.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleMedium.copy(
                            textDecoration = when (goal.status) {
                                GoalStatus.DONE -> TextDecoration.LineThrough
                                GoalStatus.UNDONE -> TextDecoration.None
                            },

                            color = when (goal.status) {
                                GoalStatus.DONE -> MaterialTheme.colorScheme.secondary
                                GoalStatus.UNDONE -> MaterialTheme.colorScheme.onPrimaryContainer
                            }
                    ),
                    modifier = Modifier.weight(1f)
            )
            Icon(
                    modifier = Modifier.weight(0.25f),
                    painter = painterResource(goal.priority.iconResourceId),
                    contentDescription = goal.priority.label,
                    tint = when (goal.priority) {
                        GoalPriority.HIGH -> MaterialTheme.colorScheme.primary
                        GoalPriority.NORMAL -> MaterialTheme.colorScheme.secondary
                    },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GoalItemPreview() {
    Column {
        Text(text = "GoalItem Preview")
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
                text = "Look at Goal List to see how it looks in a list!",
                color = MaterialTheme.colorScheme.error
        )

        Spacer(modifier = Modifier.padding(16.dp))

        GoalItem(
                goal = Goal(title = "Test Goal"),
        )
        GoalItem(
                goal = Goal(title = "Important Goal", priority = GoalPriority.HIGH),
        )
        GoalItem(
                goal = Goal(title = "Finished Goal", status = GoalStatus.DONE),
        )
        GoalItem(
                goal = Goal(
                        title = "Important Finished Goal",
                        status = GoalStatus.DONE,
                        priority = GoalPriority.HIGH
                ),
        )
        GoalItem(
                goal = Goal(
                        title = "Test Goal 2, long long goal text that " +
                                "should wrap and be displayed nicely",
                        status = GoalStatus.DONE
                ),
        )
        GoalItem(
                goal = Goal(
                        title = "Test Goal 2, long long goal text that " +
                                "should wrap and be displayed nicely " +
                                "my long goal is an example goal. this Goal just tests how a long " +
                                "goal will be shown. Maybe need to prevent extremely long goal " +
                                "? I don't know. I'm just typing to make this long.",
                        status = GoalStatus.DONE
                ),
        )
    }
}