package com.habithatch.demo.features.home

import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val goalRepository: GoalRepository
) : ViewModel() {
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _filteredGoals = MutableStateFlow<List<Goal>>(emptyList())
    val filteredGoals: StateFlow<List<Goal>> = _filteredGoals

    private var goalFilter = GoalFilter.defaultFilter

    init {
        seedGoals()
        observeUser()
        observeFilteredGoals()
    }

    fun addGoal(goalTitle: String) {
        viewModelScope.launch {
            val newGoal = Goal(title = goalTitle)
            goalRepository.insert(newGoal)
        }
    }

    fun toggleGoalDone(goal: Goal) {
        viewModelScope.launch {
            goalRepository.toggleGoalDone(goal.id)
        }
    }

    fun setFilter(filter: GoalFilter) {
        goalFilter = filter
    }

    private fun observeUser() {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                Log.d("HomeViewModel", "User emitted: $user")
                _user.value = user
            }
        }
    }

    private fun observeFilteredGoals() {
        viewModelScope.launch {
            goalRepository.getFilteredGoals(goalFilter).collect {
                _filteredGoals.value = it
            }
        }
    }

    private fun seedGoals() {
        viewModelScope.launch {
            goalRepository.seedDatabase()
        }
    }
}
