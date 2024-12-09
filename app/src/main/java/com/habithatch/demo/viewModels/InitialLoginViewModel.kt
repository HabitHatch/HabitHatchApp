package com.habithatch.demo.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class InitialLoginViewModel(private val userDao: UserDao) : ViewModel() {
    private val _isSignedUp = MutableStateFlow<Boolean?>(null)
    val isSignedUp: StateFlow<Boolean?> = _isSignedUp

    init {
        checkUserSignUpStatus()
    }

    private fun checkUserSignUpStatus() {
        viewModelScope.launch {
            val user = userDao.getUser()
            _isSignedUp.value = user != null
        }
    }

    fun signUpUser(pet: Pet) {
        viewModelScope.launch {
            val newUser = User(pet = pet)
            userDao.insertOrUpdateUser(newUser)
        }
    }
}
