package com.habithatch.demo.viewModels



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.daos.UserDao
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.entities.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class InitialLoginUiState {
    object UserSignedUp : InitialLoginUiState()
    object UserNotSignedUp : InitialLoginUiState()
}

class InitialLoginViewModel(private val userDao: UserDao) : ViewModel() {
    private val _uiState = MutableStateFlow<InitialLoginUiState>(InitialLoginUiState.UserNotSignedUp)
    val uiState: StateFlow<InitialLoginUiState> = _uiState
    private val _isSignedUp = MutableStateFlow<Boolean?>(null)
    val isSignedUp: StateFlow<Boolean?> = _isSignedUp

    init {
        checkUserSignUpStatus()
    }

    private fun checkUserSignUpStatus() {
        viewModelScope.launch {
            val user = userDao.getUser()
            if (user != null) {
                _uiState.value = InitialLoginUiState.UserSignedUp
                _isSignedUp.value = true
            } else {
                _uiState.value = InitialLoginUiState.UserNotSignedUp
                _isSignedUp.value = false
            }
        }
    }

    fun isUserSignedUp(): Boolean {
        return isSignedUp.value == true;
    }

    fun signUpUser(pet: Pet) {
        viewModelScope.launch {
            val newUser = User(pet = pet)
            userDao.insertOrUpdateUser(newUser)
            _uiState.value = InitialLoginUiState.UserSignedUp
        }
    }
}
