package com.habithatch.demo.features.home

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.exceptions.GoalNotFoundException
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.repositories.GoalRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val userRepository: UserRepository,
        private val goalRepository: GoalRepository,
        val config: HabitHatchConfig,
    ) : ViewModel() {
        private val _user = MutableStateFlow<User?>(null)
        val user: StateFlow<User?> = _user.asStateFlow()

        private val _queriedGoals = MutableStateFlow<List<GoalModel>>(emptyList())
        val filteredGoals = _queriedGoals.asStateFlow()

        private val _goalQuery = MutableStateFlow(config.getDefaultGoalQuery())
        val goalQuery = _goalQuery.asStateFlow()

        private val _allGoalsDone = MutableStateFlow(false)
        val allGoalsDone = _allGoalsDone.asStateFlow()

        init {
            seedGoals()
            observeUser()
            observeQueriedGoals()
            observeAllGoalsDone()
        }

        fun addGoal(goal: GoalModel) {
            viewModelScope.launch {
                goalRepository.insert(goal)
            }
        }

        @Throws(GoalNotFoundException::class, IllegalArgumentException::class)
        fun toggleGoalStatus(goal: GoalModel) {
            if (goal.id == null) {
                throw IllegalArgumentException("Goal must have an id to toggle status")
            }
            viewModelScope.launch {
                goalRepository.changeGoalStatusToNextInCycle(goal.id)
            }
        }

        fun updateGoalQuery(newGoalQuery: GoalQuery) {
            _goalQuery.value = newGoalQuery
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
                _goalQuery
                    .flatMapLatest { goalQuery ->
                        goalRepository.getQueriedGoals(goalQuery)
                    }.collect { goals ->
                        _queriedGoals.value = goals
                    }
            }
        }

        private fun seedGoals() {
            viewModelScope.launch {
                goalRepository.insertAll(config.exampleGoals)
            }
        }
    }
