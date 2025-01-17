package com.habithatch.demo.ui.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.ui.common.forms.DeleteButton

@Suppress("ktlint:standard:function-naming")
@Composable
fun SettingsGroup(
    @StringRes titleRes: Int,
    hasTopDivider: Boolean = true,
    content: @Composable () -> Unit,
) {
    if (hasTopDivider) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        )
    }
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
    ) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp),
        )
        content()
    }
}

/** A view that displays account settings */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AccountSettings(
    modifier: Modifier = Modifier,
    onOpenDeleteAccountDialog: () -> Unit = {},
) {
    var notificationsEnabled by remember { mutableStateOf(true) }

    Column(modifier = modifier) {
        SettingsGroup(
            titleRes = R.string.account_settings,
            hasTopDivider = false,
        ) {
            ListItem(
                headlineContent = { Text(stringResource(R.string.username)) },
                supportingContent = { Text(stringResource(R.string.user_example_email)) },
                leadingContent = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = stringResource(R.string.account_icon_description),
                    )
                },
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                DeleteButton(
                    modifier = Modifier.padding(top = 8.dp),
                    textRes = R.string.delete_account_button,
                    onClick = onOpenDeleteAccountDialog,
                )
            }
        }

        SettingsGroup(
            titleRes = R.string.about,
            hasTopDivider = true,
        ) {
            ListItem(
                headlineContent = { Text(stringResource(R.string.usage_tips)) },
            )
            ListItem(
                headlineContent = { Text(stringResource(R.string.faqs)) },
            )
            ListItem(
                headlineContent = { Text(stringResource(R.string.contact_us)) },
            )
        }

        SettingsGroup(
            titleRes = R.string.settings_group_notifications,
            hasTopDivider = true,
        ) {
            ListItem(
                headlineContent = {
                    Text(
                        stringResource(R.string.enable_notifications),
                    )
                },
                trailingContent = {
                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = {
                            notificationsEnabled = !notificationsEnabled
                        },
                    )
                },
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Preview(showBackground = true)
@Composable
fun AccountSettingsPreview() {
    AccountSettings()
}
