package com.habithatch.demo.features.settings

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

data class SettingsScreenState(
    val onDeleteAccount: () -> Unit,
)

@Composable
fun rememberSettingsScreenState(
    viewModel: SettingsViewModel = hiltViewModel(),
): SettingsScreenState =
    SettingsScreenState(
        onDeleteAccount = viewModel::deleteAccount,
    )
