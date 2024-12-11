package com.habithatch.demo.features.signup

import com.habithatch.demo.common.PetsGrid
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
        modifier = Modifier.Companion.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        PetsGrid(pets = pets, onConfirm = {
            viewModel.signUpUser(it)
        })
    }
}