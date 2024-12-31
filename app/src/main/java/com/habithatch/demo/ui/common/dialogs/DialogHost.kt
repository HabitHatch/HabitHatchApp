package com.habithatch.demo.ui.common.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * A host for dialogs.
 */
class DialogHost {
    private var dialog: @Composable (() -> Unit)? = null

    /**
     * Renders the dialog.
     */
    @Suppress("ktlint:standard:function-naming")
    @Composable
    fun Render() {
        dialog?.invoke()
    }

    /**
     * Creates a confirm dialog.
     *
     * @param titleRes The title resource ID.
     * @param messageRes The message resource ID.
     * @param confirmButtonRes The confirm button resource ID.
     * @param dismissButtonRes The dismiss button resource ID.
     * @param onConfirm The callback to run when the confirm button is clicked.
     */
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
