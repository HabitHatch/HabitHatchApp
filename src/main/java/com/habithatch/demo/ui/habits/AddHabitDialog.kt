@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.ui.habits

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
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.ui.common.forms.SimpleIconButton

/**
 * A dialog that allows the user to add a habit.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AddHabitDialog(
    state: AddHabitDialogState,
) {
    if (state.showDialog && state.habit != null) {
        var habit by remember { mutableStateOf(state.habit) }
        AlertDialog(
            onDismissRequest = { state.onDismiss() },
            title = {
                Text(text = stringResource(R.string.add_habit), style = MaterialTheme.typography.headlineSmall)
            },
            text = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    OutlinedTextField(
                        value = habit.title,
                        onValueChange = { habit = habit.copy(title = it) },
                        modifier = Modifier.weight(1f),
                        shape = MaterialTheme.shapes.small,
                        label = { Text(stringResource(R.string.habit_dialog_text_label)) },
                    )
                    SimpleIconButton(
                        modifier = Modifier.width(64.dp).padding(8.dp),
                        labelRes = R.string.priority_toggle_label,
                        color = habit.priority.getColor(),
                        painter = painterResource(id = habit.priority.iconResourceId),
                        onClick = {
                            habit =
                                habit.copy(
                                    priority =
                                        state.allPriorities.getNextHigherOrLowest(
                                            bySelector = { it.importance.value },
                                            element = habit.priority,
                                        ),
                                )
                        },
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    state.onAddHabit(habit)
                }) {
                    Text(stringResource(R.string.confirm_add_habit))
                }
            },
            dismissButton = {
                TextButton(onClick = state.onDismiss) {
                    Text(stringResource(R.string.cancel_add_habit))
                }
            },
        )
    }
}

data class AddHabitDialogState(
    val showDialog: Boolean = false,
    val habit: HabitModel? = null,
    val allPriorities: Set<HabitModel.Priority> = emptySet(),
    val onAddHabit: (HabitModel) -> Unit = {},
    val onDismiss: () -> Unit = {},
)
