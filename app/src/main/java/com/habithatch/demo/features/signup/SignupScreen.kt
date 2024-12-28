package com.habithatch.demo.features.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.habithatch.demo.ui.pets.PetsGrid

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun SignupScreen() {
    val viewModel: SignupViewModel = hiltViewModel()
    val pets = viewModel.pets
    Column(
        modifier = Modifier.Companion.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
    ) {
        PetsGrid(pets = pets, onConfirm = {
            viewModel.signUpUser(it)
        })
    }
}
