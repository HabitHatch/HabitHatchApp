@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.ui.goals

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.common.forms.SimpleIconButton

/**
 * A dialog that allows the user to add a goal.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AddGoalDialog(
    state: AddGoalDialogState,
) {
    if (state.showDialog && state.goal != null) {
        var goal by remember { mutableStateOf(state.goal) }
        AlertDialog(
            onDismissRequest = { state.onDismiss() },
            title = {
                Text(text = stringResource(R.string.add_goal), style = MaterialTheme.typography.headlineSmall)
            },
            text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    OutlinedTextField(
                        value = goal.title,
                        onValueChange = { goal = goal.copy(title = it) },
                        modifier = Modifier.weight(1f),
                        shape = MaterialTheme.shapes.small,
                        label = { Text(stringResource(R.string.goal_dialog_text_label)) },
                    )
                    SimpleIconButton(
                        modifier = Modifier.width(64.dp).padding(8.dp),
                        labelRes = R.string.priority_toggle_label,
                        color = goal.priority.getColor(),
                        painter = painterResource(id = goal.priority.iconResourceId),
                        onClick = {
                            goal =
                                goal.copy(
                                    priority =
                                        state.allPriorities.getNextHigherOrLowest(
                                            bySelector = { it.importance.value },
                                            element = goal.priority,
                                        ),
                                )
                        },
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    state.onAddGoal(goal)
                }) {
                    Text(stringResource(R.string.confirm_add_goal))
                }
            },
            dismissButton = {
                TextButton(onClick = state.onDismiss) {
                    Text(stringResource(R.string.cancel_add_goal))
                }
            },
        )
    }
}

data class AddGoalDialogState(
    val showDialog: Boolean = false,
    val goal: GoalModel? = null,
    val allPriorities: Set<GoalModel.Priority> = emptySet(),
    val onAddGoal: (GoalModel) -> Unit = {},
    val onDismiss: () -> Unit = {},
)
