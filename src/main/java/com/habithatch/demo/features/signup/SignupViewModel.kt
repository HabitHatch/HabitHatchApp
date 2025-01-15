package com.habithatch.demo.features.signup

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.exceptions.UserExistsException
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.UserModel
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SignupViewModel
    @Inject
    constructor(
        private val userRepository: UserRepository,
        habitHatchConfig: HabitHatchConfig,
    ) : ViewModel() {
        private val _signUpState = MutableStateFlow<SignUpState>(SignUpState.LOADING)
        val signUpState: StateFlow<SignUpState> = _signUpState

        val pets: List<Pet> = habitHatchConfig.pets

        init {
            observeUserSignUpStatus()
        }

        fun signUpUser(user: UserModel) {
            viewModelScope.launch {
                try {
                    userRepository.createUser(user)
                } catch (e: UserExistsException) {
                    Log.e("SignupViewModel", "Error signing up user", e)
                }
            }
        }

        private fun observeUserSignUpStatus() {
            viewModelScope.launch {
                userRepository.getUser().collect { user ->
                    _signUpState.value =
                        when (user) {
                            null -> SignUpState.NOT_SIGNED_UP
                            else -> SignUpState.SIGNED_UP
                        }
                }
            }
        }
    }
