package com.habithatch.demo.features.home

import java.util.EnumMap
import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val goalRepository: GoalRepository,
    habitHatchConfig: HabitHatchConfig
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _filteredGoals = MutableStateFlow<List<Goal>>(emptyList())
    val filteredGoals = _filteredGoals.asStateFlow()

    // Combine all filter attributes into a single MutableStateFlow for GoalFilter
    private val _goalFilter = MutableStateFlow(GoalFilter.createMatchAllFilter())
    val goalFilter = _goalFilter.asStateFlow()

    val bottomNavigationItems: List<NavigationItem> = habitHatchConfig.navigationItems
    val primaryNavigationItem: NavigationItem = habitHatchConfig.accountItem

    init {
        seedGoals()
        observeUser()
        observeFilteredGoals()
    }

    fun addGoal(goalTitle: String, goalPriority: GoalPriority) {
        viewModelScope.launch {
            val newGoal = Goal(title = goalTitle, priority = goalPriority)
            goalRepository.insert(newGoal)
        }
    }

    fun toggleGoalDone(goal: Goal) {
        viewModelScope.launch {
            goalRepository.toggleGoalDone(goal.id)
        }
    }

    fun changeSearchQuery(query: String) {
        _goalFilter.update { current ->
            current.copy(searchQuery = query)
        }
    }

    fun setDoneStateVisible(doneState: GoalStatus, visible: Boolean) {
        _goalFilter.update { current ->
            current.copy(
                    goalStatusVisibleMap = EnumMap(current.goalStatusVisibleMap).apply {
                        this[doneState] = visible
                    }
            )
        }
    }

    fun setPriorityVisibility(priority: GoalPriority, visible: Boolean) {
        _goalFilter.update { current ->
            current.copy(
                    goalPriorityVisibleMap = EnumMap(current.goalPriorityVisibleMap).apply {
                        this[priority] = visible
                    }
            )
        }
    }

    private fun observeUser() {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                Log.d("HomeViewModel", "User emitted: $user")
                _user.value = user
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeFilteredGoals() {
        Log.d("HomeViewModel", "observeFilteredGoals called")
        viewModelScope.launch {
            _goalFilter.flatMapLatest { filter ->
                goalRepository.getFilteredGoals(filter)
            }.collect { goals ->
                _filteredGoals.value = goals
            }
        }
    }

    private fun seedGoals() {
        viewModelScope.launch {
            goalRepository.seedDatabase()
        }
    }
}
