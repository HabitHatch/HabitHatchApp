package com.habithatch.demo.ui.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun ConfirmationDialog(
    state: DialogState,
    confirmButtonText: String = "Confirm",
    dismissButtonText: String = "Cancel",
) {
    if (!state.show) return
    AlertDialog(
        onDismissRequest = state.onDismiss,
        title = { Text(text = state.title, style = MaterialTheme.typography.titleLarge) },
        text = { Text(text = state.message, style = MaterialTheme.typography.bodyMedium) },
        confirmButton = {
            TextButton(onClick = state.onConfirm) {
                Text(text = confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(onClick = state.onDismiss) {
                Text(text = dismissButtonText)
            }
        },
    )
}

@Preview(showBackground = true)
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun ConfirmationDialogPreview() {
    ConfirmationDialog(
        state =
            DialogState(
                title = "Delete Goal",
                message = "Are you sure you want to delete this goal?",
                onConfirm = {},
                onDismiss = {},
            ),
    )
}
