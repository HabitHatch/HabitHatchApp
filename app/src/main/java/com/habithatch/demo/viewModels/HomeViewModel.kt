package com.habithatch.demo.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.entities.Goal
import com.habithatch.demo.entities.User
import com.habithatch.demo.repositories.GoalRepository
import com.habithatch.demo.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository,
    private val goalRepository: GoalRepository
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _goals = MutableStateFlow<List<Goal>>(emptyList())
    val goals: StateFlow<List<Goal>> = _goals

    init {
        observeUser()
        observeGoals()
    }

    private fun observeUser() {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                _user.value = user
            }
        }
    }

    private fun observeGoals() {
        viewModelScope.launch {
            goalRepository.getAll().collect {
                _goals.value = it
            }
        }
    }
}