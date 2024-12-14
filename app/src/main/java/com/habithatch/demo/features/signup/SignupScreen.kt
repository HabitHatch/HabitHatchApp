package com.habithatch.demo.features.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.habithatch.demo.common.ui.pets.PetsGrid

@Composable
fun InitialLoginScreen() {
    val viewModel: SignupViewModel = hiltViewModel()
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