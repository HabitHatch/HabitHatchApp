package com.habithatch.demo.features.home

import javax.inject.Inject
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.core.util.GoalSortOptionState
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalModel
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
    private val config: HabitHatchConfig
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _queriedGoals = MutableStateFlow<List<GoalModel>>(emptyList())
    val filteredGoals = _queriedGoals.asStateFlow()

    private val _goalQuery = MutableStateFlow(config.getDefaultGoalQuery())
    val goalQuery = _goalQuery.asStateFlow()

    private val _allGoalsDone = MutableStateFlow(false)
    val allGoalsDone = _allGoalsDone.asStateFlow()

    val bottomNavigationItems = config.navigationItems
    val primaryNavigationItem = config.accountItem
    val priorities = config.priorities
    val defaultPriority = config.defaultPriority
    val defaultStatus = config.defaultStatus

    init {
        seedGoals()
        observeUser()
        observeQueriedGoals()
        observeAllGoalsDone()
    }

    fun addGoal(
        goalTitle: String,
        goalPriority: GoalModel.Priority? = null,
        goalStatus: GoalModel.Status? = null
    ) {
        viewModelScope.launch {
            val newGoal = GoalModel(
                    title = goalTitle,
                    priority = goalPriority ?: config.defaultPriority,
                    status = goalStatus ?: config.defaultStatus
            )
            goalRepository.insert(newGoal)
        }
    }

    fun toggleGoalDone(goal: GoalModel) {
        viewModelScope.launch {
            goalRepository.changeGoalStatusToNextInCycle(goal.id)
        }
    }

    fun changeSearchQuery(query: String) {
        _goalQuery.update { current ->
            current.copy(
                    filterAttributes = current.filterAttributes
                        .builder()
                        .setSearchQuery(query)
                        .build()
            )
        }
    }

    fun setDoneStateVisible(doneState: GoalModel.Status, visible: Boolean) {
        val newFilterAttributes = _goalQuery.value.filterAttributes
            .builder()
            .setStatus(doneState, visible)
            .build()
        _goalQuery.update { currentGoalQuery ->
            currentGoalQuery.updateFilterConfig(newFilterAttributes)
        }
    }

    fun setPriorityVisible(priority: GoalModel.Priority, visible: Boolean) {
        val newFilterAttributes = _goalQuery.value.filterAttributes
            .builder()
            .setPriority(priority, visible)
            .build()
        _goalQuery.update { currentGoalQuery ->
            currentGoalQuery.updateFilterConfig(newFilterAttributes)
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
                _allGoalsDone.value = goals.all { it.isDone() }
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
