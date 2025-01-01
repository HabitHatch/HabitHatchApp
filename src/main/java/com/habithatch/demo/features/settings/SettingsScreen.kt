package com.habithatch.demo.features.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.ui.common.dialogs.DialogHost
import com.habithatch.demo.ui.settings.AccountSettings

/**
 * The settings screen composable.
 * Shows the UI for the user to change their settings.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun SettingsScreen(
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
    state: SettingsScreenState = rememberSettingsScreenState(),
) {
    var dialogHost = DialogHost()

    dialogHost.Render()

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
            ) {
                AccountSettings(
                    onOpenDeleteAccountDialog = {
                        dialogHost.createConfirmDialog(
                            titleRes = R.string.delete_account_dialog_title,
                            messageRes = R.string.delete_account_dialog_message,
                            confirmButtonRes = R.string.delete_account_dialog_positive_button,
                            dismissButtonRes = R.string.delete_account_dialog_negative_button,
                            onConfirm = state.onDeleteAccount,
                        )
                    },
                )
                HorizontalDivider()

                Text(
                    text = stringResource(R.string.notification_settings_title),
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
                HorizontalDivider()

                Text(
                    text = stringResource(R.string.theme_settings_title),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp),
                )
            }
        },
        topBar = topNavBar,
        bottomBar = bottomNavBar,
    )
}
