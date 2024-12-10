package com.habithatch.demo.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import com.habithatch.demo.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class InitialLoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _isSignedUp = MutableStateFlow<Boolean?>(null)
    val isSignedUp: StateFlow<Boolean?> = _isSignedUp

    init {
        checkUserSignUpStatus()
    }

    private fun checkUserSignUpStatus() {
        viewModelScope.launch {
            val user = userRepository.getUser()
            _isSignedUp.value = user != null
        }
    }

    fun signUpUser(pet: Pet) {
        checkUserSignUpStatus()
        viewModelScope.launch {
            val newUser = User(petId = pet.id)
            userRepository.createUser(newUser)
        }
    }
}
