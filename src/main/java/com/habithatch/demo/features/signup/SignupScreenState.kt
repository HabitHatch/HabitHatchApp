package com.habithatch.demo.features.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.UserEntity

/**
 * Represents the state of the signup screen.
 */
data class SignupScreenState(
    val pets: List<Pet>,
    val signUpState: SignUpState,
    val onPetConfirmed: (Pet) -> Unit,
)

/**
 * Represents the state of the signup screen.
 * The [SignUpState.LOADING] is needed to handle the state, that the UserEntity Information is loading.
 * Since this Information is loaded from the in memory cache, the time to load the information is
 * very short < 100ms. Therefore, the loading state is not visible to the user.
 */
enum class SignUpState {
    SIGNED_UP,
    NOT_SIGNED_UP,
    LOADING,
}

/**
 * @suppress
 */
@Composable
fun rememberSignupScreenState(
    viewModel: SignupViewModel = hiltViewModel(),
): SignupScreenState {
    val pets = viewModel.pets
    val signUpState by viewModel.signUpState.collectAsStateWithLifecycle()

    return SignupScreenState(
        pets = pets,
        signUpState = signUpState,
        onPetConfirmed = { pet -> viewModel.signUpUser(UserEntity(pet = pet)) },
    )
}
