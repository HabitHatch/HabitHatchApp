package com.habithatch.demo.features.home

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalFilterBuilderFactory
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.query.GoalSortOption
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.models.ExampleGoalFactory
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.UserModel
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
        val goalQueryFactory: GoalQuery.Factory,
        private val goalModelFactory: GoalModel.Factory,
        val builderFactory: GoalFilterBuilderFactory,
    ) : ViewModel() {
        private val _user = MutableStateFlow<UserModel?>(null)
        val user: StateFlow<UserModel?> = _user.asStateFlow()

        private val _queriedGoals = MutableStateFlow<List<GoalModel>>(emptyList())
        val queriedGoals = _queriedGoals.asStateFlow()

        private val _goalQuery = MutableStateFlow(config.defaultGoalQuery)
        val goalQuery = _goalQuery.asStateFlow()

        private val _hasAnyGoals = MutableStateFlow(false)
        val hasAnyGoals = _hasAnyGoals.asStateFlow()

        init {
            observeHasAnyGoals()
            observeUser()
            observeQueriedGoals()
            managePetsMood()
            Log.d("Pets", config.pets.toString())
        }

        fun addGoal(goal: GoalModel) {
            viewModelScope.launch {
                goalRepository.insert(goal)
            }
        }

        @Throws(IllegalArgumentException::class)
        fun toggleGoalStatus(goal: GoalModel) {
            val nextStatusInCycle =
                config.statuses.getNextHigherOrLowest(
                    bySelector = { it.stepNumber },
                    element = goal.status,
                )
            val newGoal = goal.copy(status = nextStatusInCycle)
            viewModelScope.launch {
                goalRepository.update(newGoal)
            }
        }

        fun updateGoalFilter(newGoalFilter: GoalFilter.Builder) {
            _goalQuery.value = _goalQuery.value.copy(filterBuilder = newGoalFilter)
        }

        fun updateGoalSortOption(newGoalSortOption: GoalSortOption) {
            _goalQuery.value = _goalQuery.value.updateSortOption(newGoalSortOption)
        }

        fun seedGoals() {
            viewModelScope.launch {
                if (hasAnyGoals.value) {
                    Log.e("HomeScreen", "Cannot seed goals when there are already goals in the database")
                    return@launch
                }
                if (user.value == null) {
                    Log.e("HomeScreen", "Cannot seed goals when there is no user")
                    return@launch
                }

                val exampleGoals =
                    ExampleGoalFactory(config, config, goalModelFactory)
                        .createExampleGoals(config.numberExampleGoals, user.value!!.uuid, uniqueTitles = true)
                goalRepository.insert(*exampleGoals.toTypedArray())
            }
        }

        private fun observeUser() {
            viewModelScope.launch {
                userRepository.getUser().collect {
                    _user.value = it
                }
            }
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        private fun managePetsMood() {
            viewModelScope.launch {
                user
                    .flatMapLatest {
                        Log.d("HomeViewModel", "User: $it")
                        goalRepository.getAll()
                    }.collect { allGoals ->
                        if (user.value != null) {
                            user.value!!.pet.updateMood(allGoals)
                            Log.d("HomeViewModel", "Updated pet mood: ${user.value!!.pet}")
                        }
                    }
            }
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        private fun observeQueriedGoals() {
            viewModelScope.launch {
                _goalQuery
                    .flatMapLatest { goalRepository.search(it) }
                    .collect { _queriedGoals.value = it }
            }
        }

        private fun observeHasAnyGoals() =
            viewModelScope.launch {
                goalRepository
                    .search(
                        query = goalQueryFactory.createQuery(builderFactory.matchAllBuilder),
                    ).collect { goals ->
                        _hasAnyGoals.value = goals.isEmpty().not()
                    }
            }
    }
