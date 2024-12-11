package com.habithatch.demo.common

import com.habithatch.demo.data.entities.Goal
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddGoalDialog(
    onDismiss: () -> Unit,
    onAdd: (String) -> Unit
) {
    var goalName = remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Add Goal") },
        text = {
            Column {
                Text("Enter goal name:")
                OutlinedTextField(
                    value = goalName.value,
                    onValueChange = { goalName.value = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (goalName.value.isNotBlank()) {
                        onAdd(goalName.value)
                        goalName.value = ""
                    }
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun AddGoalDialogPreview() {
    AddGoalDialog(onDismiss = {}, onAdd = {})
}