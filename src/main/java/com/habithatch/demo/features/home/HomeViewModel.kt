package com.habithatch.demo.features.home

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.query.HabitFilter
import com.habithatch.demo.core.query.HabitFilterBuilderFactory
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.core.query.HabitSortOption
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.models.ExampleHabitFactory
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.data.models.UserModel
import com.habithatch.demo.data.repositories.HabitRepository
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
        private val habitRepository: HabitRepository,
        val config: HabitHatchConfig,
        val habitQueryFactory: HabitQuery.Factory,
        private val habitModelFactory: HabitModel.Factory,
        val builderFactory: HabitFilterBuilderFactory,
    ) : ViewModel() {
        private val _user = MutableStateFlow<UserModel?>(null)
        val user: StateFlow<UserModel?> = _user.asStateFlow()

        private val _queriedHabits = MutableStateFlow<List<HabitModel>>(emptyList())
        val queriedHabits = _queriedHabits.asStateFlow()

        private val _habitQuery = MutableStateFlow(config.defaultHabitQuery)
        val habitQuery = _habitQuery.asStateFlow()

        private val _hasAnyHabits = MutableStateFlow(false)
        val hasAnyHabits = _hasAnyHabits.asStateFlow()

        init {
            observeHasAnyHabits()
            observeUser()
            observeQueriedHabits()
            managePetsMood()
            Log.d("Pets", config.pets.toString())
        }

        fun addHabit(habit: HabitModel) {
            viewModelScope.launch {
                habitRepository.insert(habit)
            }
        }

        @Throws(IllegalArgumentException::class)
        fun toggleHabitStatus(habit: HabitModel) {
            val nextStatusInCycle =
                config.statuses.getNextHigherOrLowest(
                    bySelector = { it.stepNumber },
                    element = habit.status,
                )
            val newHabit = habit.copy(status = nextStatusInCycle)
            viewModelScope.launch {
                habitRepository.update(newHabit)
            }
        }

        fun updateHabitFilter(newHabitFilter: HabitFilter.Builder) {
            _habitQuery.value = _habitQuery.value.copy(filterBuilder = newHabitFilter)
        }

        fun updateHabitSortOption(newHabitSortOption: HabitSortOption) {
            _habitQuery.value = _habitQuery.value.updateSortOption(newHabitSortOption)
        }

        fun seedHabits() {
            viewModelScope.launch {
                if (hasAnyHabits.value) {
                    Log.e("HomeScreen", "Cannot seed habits when there are already habits in the database")
                    return@launch
                }
                if (user.value == null) {
                    Log.e("HomeScreen", "Cannot seed habits when there is no user")
                    return@launch
                }

                val exampleHabits =
                    ExampleHabitFactory(config, config, habitModelFactory)
                        .createExampleHabits(config.numberExampleHabits, user.value!!.uuid, uniqueTitles = true)
                habitRepository.insert(*exampleHabits.toTypedArray())
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
                        habitRepository.getAll()
                    }.collect { allHabits ->
                        if (user.value != null) {
                            user.value!!.pet.updateMood(allHabits)
                            Log.d("HomeViewModel", "Updated pet mood: ${user.value!!.pet}")
                        }
                    }
            }
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        private fun observeQueriedHabits() {
            viewModelScope.launch {
                _habitQuery
                    .flatMapLatest { habitRepository.search(it) }
                    .collect { _queriedHabits.value = it }
            }
        }

        private fun observeHasAnyHabits() =
            viewModelScope.launch {
                habitRepository
                    .search(
                        query = habitQueryFactory.createQuery(builderFactory.matchAllBuilder),
                    ).collect { habits ->
                        _hasAnyHabits.value = habits.isEmpty().not()
                    }
            }
    }
