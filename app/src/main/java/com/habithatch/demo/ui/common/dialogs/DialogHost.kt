package com.habithatch.demo.ui.common.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

class DialogHost {
    private var dialog: @Composable (() -> Unit)? = null

    @Composable
    fun Render() {
        dialog?.invoke()
    }

    fun createConfirmDialog(
        titleRes: Int,
        messageRes: Int,
        confirmButtonRes: Int,
        dismissButtonRes: Int,
        onConfirm: () -> Unit,
    ) {
        dialog = {
            AlertDialog(
                onDismissRequest = { dialog = null },
                title = { Text(stringResource(titleRes)) },
                text = { Text(stringResource(messageRes)) },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onConfirm()
                            dialog = null
                        },
                    ) {
                        Text(stringResource(confirmButtonRes))
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { dialog = null },
                    ) {
                        Text(stringResource(dismissButtonRes))
                    }
                },
            )
        }
    }
}
