package com.habithatch.demo.features.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class SettingsViewModel
    @Inject
    constructor(
        private val userRepository: UserRepository,
        private val goalRepository: GoalRepository,
    ) : ViewModel() {
        fun deleteAccount() {
            viewModelScope.launch {
                goalRepository.deleteAll()
                userRepository.deleteUser()
            }
        }
    }
