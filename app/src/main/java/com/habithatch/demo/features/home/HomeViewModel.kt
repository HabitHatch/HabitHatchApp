package com.habithatch.demo.features.home

import java.util.EnumMap
import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.util.GoalSortOptionState
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.User
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

    private val _queriedGoals = MutableStateFlow<List<Goal>>(emptyList())
    val filteredGoals = _queriedGoals.asStateFlow()

    private val _goalQuery = MutableStateFlow(habitHatchConfig.defaultGoalQuery)
    val goalQuery = _goalQuery.asStateFlow()

    private val _allGoalsDone = MutableStateFlow(false)
    val allGoalsDone = _allGoalsDone.asStateFlow()

    val bottomNavigationItems: List<NavigationItem> = habitHatchConfig.navigationItems
    val primaryNavigationItem: NavigationItem = habitHatchConfig.accountItem
    val priorities: List<GoalPriority> = habitHatchConfig.priorities

    init {
        seedGoals()
        observeUser()
        observeQueriedGoals()
        observeAllGoalsDone()
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
        _goalQuery.update { current ->
            current.copy(filterConfig = current.filterConfig.copy(searchQuery = query))
        }
    }

    fun setDoneStateVisible(doneState: GoalStatus, visible: Boolean) {
        _goalQuery.update { current ->
            current.copy(
                    filterConfig = current.filterConfig.copy(
                            goalStatusVisibleMap = EnumMap(current.filterConfig.goalStatusVisibleMap).apply {
                                this[doneState] = visible
                            }
                    )
            )
        }
    }

    fun setPriorityVisible(priority: GoalPriority, visible: Boolean) {
        _goalQuery.update { current ->
            val newFilterConfig = current.filterConfig.copy(
                    goalPriorityVisibleMap = current.filterConfig
                        .goalPriorityVisibleMap
                        .apply { this[priority] = visible }
            )
            current.updateFilterConfig(newFilterConfig,)
        }
    }

    fun toggleSortOptionState(sortOptionState: GoalSortOptionState) {
        // TODO: Implement
    }

    private fun observeUser() {
        viewModelScope.launch {
            userRepository.getUser().collect { user ->
                Log.d("HomeViewModel", "User emitted: $user")
                _user.value = user
            }
        }
    }

    private fun observeAllGoalsDone() {
        viewModelScope.launch {
            goalRepository.getAll().collect { goals ->
                _allGoalsDone.value = goals.all { it.status == GoalStatus.DONE }
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeQueriedGoals() {
        Log.d("HomeViewModel", "observeFilteredGoals called")
        viewModelScope.launch {
            _goalQuery.flatMapLatest { query ->
                goalRepository.getQueriedGoals(query)
            }.collect { goals ->
                _queriedGoals.value = goals
            }
        }
    }

    private fun seedGoals() {
        viewModelScope.launch {
            goalRepository.seedDatabase()
        }
    }
}
