package com.habithatch.demo.ui.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ConfirmationDialog(
    title: String,
    message: String,
    confirmButtonText: String = "Confirm",
    dismissButtonText: String = "Cancel",
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = title, style = MaterialTheme.typography.titleLarge) },
            text = { Text(text = message, style = MaterialTheme.typography.bodyMedium) },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = dismissButtonText)
                }
            }
    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmationDialogPreview() {
    ConfirmationDialog(
            title = "Delete Goal",
            message = "Are you sure you want to delete this goal?",
            onConfirm = {},
            onDismiss = {}
    )
}