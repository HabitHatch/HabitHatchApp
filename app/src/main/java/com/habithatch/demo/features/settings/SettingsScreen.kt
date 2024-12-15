package com.habithatch.demo.features.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import BottomNavigationBar
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.habithatch.demo.ui.common.ConfirmationDialog
import com.habithatch.demo.core.navigation.NavigationItem

data class DialogState(
    val show: Boolean = false,
    val title: String = "",
    val message: String = "",
    val onConfirmAction: () -> Unit = {},
)

@Composable
fun SettingsScreen(
    navController: NavHostController,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val bottomNavigationItems = viewModel.bottomNavigationItems
    val selectedItem: NavigationItem? =
        NavigationItem.findNavigationItemByRoute(
                route = navController.currentBackStackEntry?.destination?.route,
                navigationItems = bottomNavigationItems
        )
    var dialogState by remember { mutableStateOf(DialogState()) }

    Scaffold(
            content = { paddingValues ->
                Column(
                        modifier = Modifier.padding(paddingValues),
                ) {
                    if (dialogState.show) {
                        ConfirmationDialog(
                                title = dialogState.title,
                                message = dialogState.message,
                                onConfirm = dialogState.onConfirmAction,
                                onDismiss = {
                                    dialogState = DialogState()
                                }
                        )
                    }
                    Text(
                            text = "Account",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(16.dp)
                    )
                    ListItem(
                            headlineContent = { Text("Username") },
                            supportingContent = { Text("user@example.com") },
                            leadingContent = {
                                Icon(Icons.Default.Person, contentDescription = "Account")
                            },
                            modifier = Modifier.clickable { }
                    )
                    Button(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onClick = {
                                dialogState = DialogState(
                                        show = true,
                                        title = "Delete Account",
                                        message = "Are you sure you want to delete your account?",
                                        onConfirmAction = {
                                            viewModel.deleteAccount()
                                        }
                                )
                            }) {
                        Text("Delete Account")
                    }
                    HorizontalDivider()

                    Text(
                            text = "Notifications",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(16.dp)
                    )
                    ListItem(
                            headlineContent = { Text("Enable Notifications") },
                            trailingContent = {
                                Switch(
                                        checked = true,
                                        onCheckedChange = { }
                                )
                            }
                    )
                    HorizontalDivider()

                    Text(
                            text = "Theme",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(16.dp)
                    )
                    var selectedTheme by remember { mutableStateOf("System Default") }
                    val themes = listOf("Light", "Dark", "System Default")
                    themes.forEach { theme ->
                        RadioButton(
                                selected = selectedTheme == theme,
                                onClick = { selectedTheme = theme }
                        )
                        Text(
                                text = theme,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .clickable { selectedTheme = theme }
                        )
                    }
                }
            },

            bottomBar = {
                BottomNavigationBar(
                        navigationItems = bottomNavigationItems,
                        activeNavigationItem = selectedItem,
                        onNavigationItemClicked = {
                            navController.navigate(it.screen.route)
                        }
                )
            }
    )
}