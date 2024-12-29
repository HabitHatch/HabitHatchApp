package com.habithatch.demo.features.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.habithatch.demo.ui.settings.AccountSettings

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun SettingsScreen(
    topNavBar: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
    state: SettingsScreenState = rememberSettingsScreenState(),
) {
    Scaffold(
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
            ) {
                AccountSettings(
                    onDeleteAccount = state.onDeleteAccount,
                )
                HorizontalDivider()

                Text(
                    text = "Notifications",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp),
                )
                ListItem(
                    headlineContent = { Text("Enable Notifications") },
                    trailingContent = {
                        Switch(
                            checked = true,
                            onCheckedChange = { },
                        )
                    },
                )
                HorizontalDivider()

                Text(
                    text = "Theme",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(16.dp),
                )
                var selectedTheme by remember { mutableStateOf("System Default") }
                val themes = listOf("Light", "Dark", "System Default")
                themes.forEach { theme ->
                    RadioButton(
                        selected = selectedTheme == theme,
                        onClick = { selectedTheme = theme },
                    )
                    Text(
                        text = theme,
                        modifier =
                            Modifier
                                .padding(start = 8.dp)
                                .clickable { selectedTheme = theme },
                    )
                }
            }
        },
        topBar = topNavBar,
        bottomBar = bottomNavBar,
    )
}
