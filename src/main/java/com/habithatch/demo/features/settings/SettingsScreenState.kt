package com.habithatch.demo.features.settings

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Represents the state of the settings screen.
 *
 * @param onDeleteAccount The callback to delete the user account.
 */
data class SettingsScreenState(
    val onDeleteAccount: () -> Unit,
)

/**
 * @suppress
 */
@Composable
fun rememberSettingsScreenState(
    viewModel: SettingsViewModel = hiltViewModel(),
): SettingsScreenState =
    SettingsScreenState(
        onDeleteAccount = viewModel::deleteAccount,
    )
