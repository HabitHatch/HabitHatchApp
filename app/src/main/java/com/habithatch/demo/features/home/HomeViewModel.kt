package com.habithatch.demo.features.home

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.query.GoalSortOption
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
        val queriedGoals = _queriedGoals.asStateFlow()

        private val _goalQuery = MutableStateFlow(config.defaultGoalQuery)
        val goalQuery = _goalQuery.asStateFlow()

        private val _allGoalsDone = MutableStateFlow(false)
        val allGoalsDone = _allGoalsDone.asStateFlow()

        private val _hasAnyGoals = MutableStateFlow(false)
        val hasAnyGoals = _hasAnyGoals.asStateFlow()

        init {
            observeHasAnyGoals()
            observeUser()
            observeQueriedGoals()
            observeAllGoalsDone()
        }

        fun addGoal(goal: GoalModel) {
            viewModelScope.launch {
                goalRepository.insert(goal)
            }
        }

        @Throws(IllegalArgumentException::class)
        fun toggleGoalStatus(goal: GoalModel) {
            viewModelScope.launch {
                goalRepository.cycleGoalStatus(goal)
            }
        }

        fun updateGoalFilter(newGoalFilter: GoalFilter) {
            _goalQuery.value = _goalQuery.value.copy(filter = newGoalFilter)
        }

        fun updateGoalSortOption(newGoalSortOption: GoalSortOption) {
            _goalQuery.value = _goalQuery.value.updateSortOption(newGoalSortOption)
        }

        fun updateGoalQuery(newGoalQuery: GoalQuery) {
            _goalQuery.value = newGoalQuery
        }

        fun seedGoals() {
            viewModelScope.launch {
                if (hasAnyGoals.value) {
                    Log.e("HomeScreen", "Cannot seed goals when there are already goals in the database")
                }
                goalRepository.insertAll(config.exampleGoals)
            }
        }

        private fun observeUser() {
            viewModelScope.launch {
                userRepository.getUser().collect { user ->
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
            viewModelScope.launch {
                _goalQuery
                    .flatMapLatest { goalQuery ->
                        goalRepository.getQueriedGoals(goalQuery)
                    }.collect { goals ->
                        _queriedGoals.value = goals
                    }
            }
        }

        private fun observeHasAnyGoals() =
            viewModelScope.launch {
                goalRepository
                    .getAll()
                    .collect { goals ->
                        _hasAnyGoals.value = goals.isEmpty().not()
                    }
            }
    }
