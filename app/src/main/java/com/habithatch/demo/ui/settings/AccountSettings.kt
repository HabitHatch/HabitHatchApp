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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AccountSettings(
    onOpenDeleteAccountDialog: () -> Unit,
) {
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
    Button(onClick = onOpenDeleteAccountDialog,) {
        Text(stringResource(R.string.delete_account_button))
    }
}
