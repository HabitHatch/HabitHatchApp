package com.habithatch.demo.features.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.habithatch.demo.R
import com.habithatch.demo.ui.common.dialogs.DialogHost
import com.habithatch.demo.ui.settings.AccountSettings
import com.habithatch.demo.ui.settings.SettingsGroup

/**
 * The settings screen composable.
 * Showing the UI for the user to change their settings.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun SettingsScreen(
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
    state: SettingsScreenState = rememberSettingsScreenState(),
) {
    val dialogHost = DialogHost()
    var notificationsEnabled by remember { mutableStateOf(true) }
    dialogHost.Render()

    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).padding(horizontal = 8.dp),
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
        },
        topBar = topNavBar,
        bottomBar = bottomNavBar,
    )
}
