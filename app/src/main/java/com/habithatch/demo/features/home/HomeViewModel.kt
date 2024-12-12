package com.habithatch.demo.features.home

import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalDoneState
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val goalRepository: GoalRepository
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _filteredGoals = MutableStateFlow<List<Goal>>(emptyList())
    val filteredGoals = _filteredGoals.asStateFlow()

    private val _searchQuery = MutableStateFlow<String?>(null)
    val searchQuery = _searchQuery.asStateFlow()

    private val _doneStateVisibleMap =
        MutableStateFlow(GoalDoneState.entries.associateWith { true })
    val doneStateVisibleMap = _doneStateVisibleMap.asStateFlow()


    private val _priorityVisibleMap = MutableStateFlow(GoalPriority.entries.associateWith { true })
    val priorityVisibleMap = _priorityVisibleMap.asStateFlow()

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

    fun changeSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setDoneStateVisible(doneState: GoalDoneState, visible: Boolean) {
        _doneStateVisibleMap.update {
            it.toMutableMap().apply {
                this[doneState] = visible
            }
        }
    }

    fun setPriorityVisibility(priority: GoalPriority, visible: Boolean) {
        _priorityVisibleMap.update {
            it.toMutableMap().apply {
                this[priority] = visible
            }
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
            combine(
                    searchQuery,
                    doneStateVisibleMap,
                    priorityVisibleMap
            ) { query, doneMap, priorityMap ->
                GoalFilter(
                        searchQuery = query,
                        doneStateVisibleMap = doneMap,
                        priorityVisibleMap = priorityMap
                )
            }.flatMapLatest { filter ->
                goalRepository.getFilteredGoals(filter)
            }.collect {
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
