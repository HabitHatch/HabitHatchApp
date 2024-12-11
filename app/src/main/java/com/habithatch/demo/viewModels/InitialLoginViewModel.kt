package com.habithatch.demo.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import com.habithatch.demo.repositories.PetRepository
import com.habithatch.demo.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class InitialLoginViewModel(
    private val userRepository: UserRepository, petRepository: PetRepository
) : ViewModel() {
    private val _isSignedUp = MutableStateFlow<Boolean?>(null)
    val isSignedUp: StateFlow<Boolean?> = _isSignedUp

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
            userRepository.getUserFlow().collect { user ->
                _isSignedUp.value = user != null
            }
        }
    }
}
