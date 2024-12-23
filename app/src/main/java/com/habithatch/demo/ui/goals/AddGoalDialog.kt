package com.habithatch.demo.ui.goals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun AddGoalDialog(
    preselectedGoal: GoalModel,
    dialogTitle: String = "Add Goal",
    blankGoalSubmissionErrorMessage: String = "Goal name cannot be empty",
    onDismiss: () -> Unit,
    onAdd: (GoalModel) -> Unit,
) {
    var goal by remember { mutableStateOf(preselectedGoal) }
    var addedBlankGoal by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.large,
                    ).padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 8.dp),
        ) {
            Column {
                Text(
                    text = dialogTitle,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 16.dp),
                )
                if (addedBlankGoal) {
                    Text(
                        text = blankGoalSubmissionErrorMessage,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(bottom = 4.dp),
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    OutlinedTextField(
                        value = goal.title,
                        onValueChange = {
                            goal = goal.copy(title = it)
                            addedBlankGoal = false
                        },
                        modifier =
                            Modifier
                                .weight(1f)
                                .padding(end = 4.dp),
                        shape = MaterialTheme.shapes.medium,
                        isError = addedBlankGoal,
                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(36.dp),
                    ) {
                        Icon(
                            painter = painterResource(id = goal.priority.iconResourceId),
                            contentDescription = goal.priority.label,
                            tint = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(
                        onClick = {
                            if (goal.title.isNotBlank()) {
                                onAdd(goal)
                                return@TextButton
                            }
                            addedBlankGoal = true
                        },
                    ) {
                        Text("Add")
                    }
                }
            }
        }
    }
}
