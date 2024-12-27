package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.models.GoalModel

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AddGoalDialog(
    state: AddGoalDialogState,
    dialogTitle: String = "Add Goal",
) {
    if (state.showDialog) {
        AlertDialog(
            onDismissRequest = state::dismiss,
            title = {
                Text(text = dialogTitle, style = MaterialTheme.typography.headlineSmall)
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = state.goalTitle,
                        onValueChange = state::onTitleChange,
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Goal Name") },
                        isError = state.addedBlankGoal,
                        supportingText = {
                            if (state.addedBlankGoal) {
                                Text(
                                    text = state.blankGoalSubmissionErrorMessage,
                                    color = MaterialTheme.colorScheme.error,
                                )
                            }
                        },
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    PriorityToggle(
                        priority = state.goal.priority,
                        onPriorityToggle = state::togglePriority,
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = state::addGoalIfValid) {
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
    val onAddGoal: (GoalModel) -> Unit = {},
    val onDismiss: () -> Unit = {},
) {
    var goalTitle by mutableStateOf(goal.title)
    var addedBlankGoal by mutableStateOf(false)
    val blankGoalSubmissionErrorMessage = "Goal name cannot be empty"

    fun onTitleChange(newTitle: String) {
        goalTitle = newTitle
        addedBlankGoal = false
    }

    fun togglePriority() {
        val newPriority =
            allPriorities.getNextHigherOrLowest(
                bySelector = { it.importance },
                element = goal.priority,
            )
        updateGoal(priority = newPriority)
    }

    fun addGoalIfValid() {
        if (goalTitle.isNotBlank()) {
            onAddGoal(goal.copy(title = goalTitle))
        } else {
            addedBlankGoal = true
        }
    }

    fun dismiss() {
        onDismiss()
    }

    private fun updateGoal(
        title: String = goalTitle,
        priority: GoalModel.Priority = goal.priority,
    ) {
        goal.copy(title = title, priority = priority).also {
            goalTitle = it.title
        }
    }
}
