package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AddGoalDialog(
    state: AddGoalDialogState,
    dialogTitle: String = "Add Goal",
) {
    var goal by remember { mutableStateOf(state.goal) }
    if (state.showDialog) {
        AlertDialog(
            onDismissRequest = { state.onDismiss() },
            title = {
                Text(text = dialogTitle, style = MaterialTheme.typography.headlineSmall)
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = goal.title,
                        onValueChange = { goal = goal.copy(title = it) },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Goal Name") },
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    IconToggle(
                        label = goal.priority.label,
                        color = goal.priority.getColor(),
                        painter = painterResource(id = goal.priority.iconResourceId),
                        onToggle = {
                            val newPriority =
                                state.allPriorities.getNextHigherOrLowest(
                                    bySelector = { it.importance.value },
                                    element = goal.priority,
                                )
                            goal = goal.copy(priority = newPriority)
                        },
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    state.onAddGoal(state.goal)
                }) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(onClick = state::dismiss) {
                    Text("Cancel")
                }
            },
        )
    }
}

data class AddGoalDialogState(
    val showDialog: Boolean,
    val goal: GoalModel,
    val allPriorities: Set<GoalModel.Priority>,
    val togglePriority: () -> Unit = {},
    val onAddGoal: (GoalModel) -> Unit = {},
    val onDismiss: () -> Unit = {},
    val onGoalChange: (GoalModel) -> Unit = {},
) {
    fun dismiss() {
        onDismiss()
    }
}
