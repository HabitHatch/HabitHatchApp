package com.habithatch.demo.features.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User

data class SignupScreenState(
    val pets: List<Pet>,
    val signUpState: SignUpState,
    val onPetConfirmed: (Pet) -> Unit,
)

enum class SignUpState {
    SIGNED_UP,
    NOT_SIGNED_UP,
    LOADING,
}

@Composable
fun rememberSignupScreenState(
    viewModel: SignupViewModel = hiltViewModel(),
): SignupScreenState {
    val pets = viewModel.pets
    val signUpState by viewModel.signUpState.collectAsStateWithLifecycle()

    return SignupScreenState(
        pets = pets,
        signUpState = signUpState,
        onPetConfirmed = { pet -> viewModel.signUpUser(User(pet = pet)) },
    )
}
