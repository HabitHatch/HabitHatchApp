package com.habithatch.demo.features.settings

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

/** Represents the state of the settings screen. */
data class SettingsScreenState(
    val onDeleteAccount: () -> Unit,
)

/** @suppress */
@Composable
fun rememberSettingsScreenState(
    viewModel: SettingsViewModel = hiltViewModel(),
) = SettingsScreenState(
    onDeleteAccount = viewModel::deleteAccount,
)
