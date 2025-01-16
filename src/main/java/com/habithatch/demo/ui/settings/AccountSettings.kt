package com.habithatch.demo.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Switch
import androidx.compose.ui.Alignment
import com.habithatch.demo.R

/**
 * A view that displays account settings.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AccountSettings(
    onOpenDeleteAccountDialog: () -> Unit,
    )
{
    Column(modifier = Modifier.padding(8.dp)) {
Text(
        text = stringResource(id = R.string.account_settings),
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(16.dp),
    )
    ListItem(
        headlineContent = { Text("Username") },
        supportingContent = { Text("user@example.com") },
        leadingContent = {
            Icon(Icons.Default.Person, contentDescription = stringResource(R.string.account_icon_description))
        },
        modifier = Modifier.clickable { },
    )

        Box( // Added Box to center the button
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            contentAlignment = Alignment.Center,
        )
        {
    Button(onClick = onOpenDeleteAccountDialog,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError,
        ), ) {

        Text(stringResource(R.string.delete_account_button))
    }
}
        Text(
            text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp),
        )
        Column {
            ListItem(
                headlineContent = { Text("Usage Tips")},
            )
            ListItem(
                headlineContent = { Text("FAQs") },
            )
            ListItem(
                headlineContent = { Text("Contact Us") },
            )
        }

        Text(
            text = stringResource(id = R.string.notification_toggle),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp),
        )
        ListItem(
            headlineContent = {
                Text(
                    stringResource(R.string.enable_notifications),
                )
            },
            trailingContent = {
                Switch(
                    checked = true,
                    onCheckedChange = { },
                )
            },
        )
    }

}
