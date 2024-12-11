package com.habithatch.demo.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
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

    fun addGoal(goalTitle: String) {
        viewModelScope.launch {
            val newGoal = Goal(title = goalTitle)
            goalRepository.insert(newGoal)
        }
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