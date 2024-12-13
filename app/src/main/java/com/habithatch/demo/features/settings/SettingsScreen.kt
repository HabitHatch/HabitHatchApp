package com.habithatch.demo.features.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.habithatch.demo.core.navigation.Screen

@Composable
fun SettingsScreen(navController: NavHostController) {
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Settings")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { settingsViewModel.deleteAccount() }) {
            Text("Delete Account")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Text("Go to Home")
        }
    }

}