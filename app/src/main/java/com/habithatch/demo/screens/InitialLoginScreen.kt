package com.habithatch.demo.screens

import com.habithatch.demo.components.PetsGrid
import com.habithatch.demo.viewModels.InitialLoginViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun InitialLoginScreen(
    viewModel: InitialLoginViewModel
) {
    val pets = viewModel.pets
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PetsGrid(pets = pets, onConfirm = {
            viewModel.signUpUser(it)
        })
    }
}