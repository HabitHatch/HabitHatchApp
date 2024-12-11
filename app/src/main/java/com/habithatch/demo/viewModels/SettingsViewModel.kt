package com.habithatch.demo.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.repositories.UserRepository
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val userRepository: UserRepository,
): ViewModel() {

    fun deleteAccount() {
        viewModelScope.launch {
            userRepository.deleteUser()
        }
    }
}