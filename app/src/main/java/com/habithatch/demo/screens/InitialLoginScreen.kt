package com.habithatch.demo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.habithatch.demo.Screen
import com.habithatch.demo.components.PetsGrid
import com.habithatch.demo.config.AppConfiguration
import com.habithatch.demo.entities.Pet

@Composable
fun InitialLoginScreen(navController: NavHostController, onSignUp: (Pet) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PetsGrid(pets = AppConfiguration.pets, onConfirm = onSignUp)
    }
}