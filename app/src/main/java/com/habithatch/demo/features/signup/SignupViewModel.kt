package com.habithatch.demo.features.signup

import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.repositories.PetRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

enum class SignUpStatus {
    SIGNED_UP,
    NOT_SIGNED_UP,
    LOADING
}

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository,
    petRepository: PetRepository
) : ViewModel() {
    private val _isSignedUp = MutableStateFlow<SignUpStatus>(SignUpStatus.LOADING)
    val isSignedUp: StateFlow<SignUpStatus> = _isSignedUp

    val pets: List<Pet> = petRepository.getAll()

    init {
        observeUserSignUpStatus()
    }

    fun signUpUser(pet: Pet) {
        viewModelScope.launch {
            val user = User(pet = pet)
            userRepository.createUser(user)
        }
    }

    private fun observeUserSignUpStatus() {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                _isSignedUp.value = when (user) {
                    null -> {
                        Log.e("SignupViewModel", "User is not signed up")
                        SignUpStatus.NOT_SIGNED_UP
                    }
                    else -> {
                        Log.e("SignupViewModel", "User is signed up")
                        SignUpStatus.SIGNED_UP
                    }
                }
            }
        }
    }
}