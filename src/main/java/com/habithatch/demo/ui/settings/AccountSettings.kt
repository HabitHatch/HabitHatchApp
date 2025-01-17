package com.habithatch.demo.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R

/**
 * A view that displays account settings.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AccountSettings(
    onOpenDeleteAccountDialog: () -> Unit,
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(id = R.string.account_settings),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp),
        )
        ListItem(
            headlineContent = { Text("Username") },
            supportingContent = { Text("user@example.com") },
            leadingContent = {
                Icon(Icons.Default.Person, contentDescription = stringResource(R.string.account_icon_description))
            },
            modifier = Modifier.clickable { },
        )

        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                onClick = onOpenDeleteAccountDialog,
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError,
                    ),
            ) {
                Text(stringResource(R.string.delete_account_button))
            }
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            thickness = 1.dp,
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
        )

        Text(
            text = stringResource(id = R.string.about),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp),
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            ListItem(
                headlineContent = { Text("Usage Tips") },
                modifier = Modifier.padding(vertical = 2.dp),
            )
            ListItem(
                headlineContent = { Text("FAQs") },
                modifier = Modifier.padding(vertical = 2.dp),
            )
            ListItem(
                headlineContent = { Text("Contact Us") },
                modifier = Modifier.padding(vertical = 2.dp),
            )
        }
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp),
        )

        Text(
            text = stringResource(id = R.string.notification_toggle),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(8.dp),
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
