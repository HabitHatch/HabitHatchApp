package com.habithatch.demo.features.signup

import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.core.exceptions.UserAlreadyExistsException
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

enum class SignUpState {
    SIGNED_UP,
    NOT_SIGNED_UP,
    LOADING
}

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    habitHatchConfig: HabitHatchConfig
) : ViewModel() {
    private val _isSignedUp = MutableStateFlow<SignUpState>(SignUpState.LOADING)
    val signUpState: StateFlow<SignUpState> = _isSignedUp

    val pets: List<Pet> = habitHatchConfig.pets

    init {
        observeUserSignUpStatus()
    }

    fun signUpUser(pet: Pet) {
        viewModelScope.launch {
            try {
                val user = User(pet = pet)
                userRepository.createUser(user)
            } catch(e: UserAlreadyExistsException) {
                Log.e("SignupViewModel", "Error signing up user", e)
                _isSignedUp.value = SignUpState.SIGNED_UP
            } catch (e: Exception) {
                Log.e("SignupViewModel", "Error signing up user", e)
            }
        }
    }

    private fun observeUserSignUpStatus() {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                _isSignedUp.value = when (user) {
                    null -> SignUpState.NOT_SIGNED_UP
                    else -> SignUpState.SIGNED_UP
                }
            }
        }
    }
}