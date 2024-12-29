package com.habithatch.demo.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.ui.common.dialogs.ConfirmationDialog
import com.habithatch.demo.ui.common.dialogs.DialogState

@Suppress("ktlint:standard:function-naming","FunctionNaming")
@Composable
fun AccountSettings(
    onDeleteAccount: () -> Unit,
) {
    var dialogState by remember { mutableStateOf<DialogState>(DialogState()) }

    ConfirmationDialog(dialogState)
    Text(
        text = "Account",
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(16.dp),
    )
    ListItem(
        headlineContent = { Text("Username") },
        supportingContent = { Text("user@example.com") },
        leadingContent = {
            Icon(Icons.Default.Person, contentDescription = "Account")
        },
        modifier = Modifier.clickable { },
    )
    Button(
        onClick = {
            dialogState =
                DialogState(
                    title = "Delete Account",
                    message = "Are you sure you want to delete your account?",
                    onConfirm = onDeleteAccount,
                    onDismiss = { dialogState = DialogState() },
                )
        },
    ) {
        Text("Delete Account")
    }
}
