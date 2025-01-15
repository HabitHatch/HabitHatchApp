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
import com.habithatch.demo.data.entities.User
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.data.repositories.HabitRepository
import com.habithatch.demo.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
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
        val builderFactory: HabitFilterBuilderFactory,
    ) : ViewModel() {
        private val _user = MutableStateFlow<User?>(null)
        val user: StateFlow<User?> = _user.asStateFlow()

        private val _queriedHabits = MutableStateFlow<List<HabitModel>>(emptyList())
        val queriedHabits = _queriedHabits.asStateFlow()

        private val _habitQuery = MutableStateFlow(config.defaultHabitQuery)
        val habitQuery = _habitQuery.asStateFlow()

        private val _allHabitsDone = MutableStateFlow(false)
        val allHabitsDone = _allHabitsDone.asStateFlow()

        private val _hasAnyHabits = MutableStateFlow(false)
        val hasAnyHabits = _hasAnyHabits.asStateFlow()

        init {
            observeHasAnyHabits()
            observeUser()
            observeQueriedHabits()
            observeAllHabitsDone()
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

        fun updateHabitFilter(newHabitFilter: HabitFilter) {
            _habitQuery.value = _habitQuery.value.copy(filter = newHabitFilter)
        }

        fun updateHabitSortOption(newHabitSortOption: HabitSortOption) {
            _habitQuery.value = _habitQuery.value.updateSortOption(newHabitSortOption)
        }

        fun seedHabits() {
            viewModelScope.launch {
                if (hasAnyHabits.value) {
                    Log.e("HomeScreen", "Cannot seed habits when there are already habits in the database")
                }
                habitRepository.insert(*config.exampleHabits.toTypedArray())
            }
        }

        private fun observeUser() {
            viewModelScope.launch {
                userRepository.getUser().collect { user ->
                    _user.value = user
                }
            }
        }

        private fun getDoneHabits(): Flow<List<HabitModel>> {
            val doneStatus = config.statuses.find { it.isDone }
            check(doneStatus != null) { "No done status found" }

            return habitRepository.getQueriedHabits(
                query =
                    habitQueryFactory.createFilterQuery(
                        filter = builderFactory.matchAllBuilder.onlyMatch(doneStatus).build(),
                    ),
            )
        }

        private fun observeAllHabitsDone() {
            viewModelScope.launch {
                getDoneHabits().collect { habits ->
                    _allHabitsDone.value = habits.isEmpty()
                }
            }
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        private fun observeQueriedHabits() {
            viewModelScope.launch {
                _habitQuery
                    .flatMapLatest { habitQuery ->
                        habitRepository.getQueriedHabits(habitQuery)
                    }.collect { habits ->
                        _queriedHabits.value = habits
                    }
            }
        }

        private fun observeHasAnyHabits() =
            viewModelScope.launch {
                habitRepository
                    .getQueriedHabits(
                        query = habitQueryFactory.createFilterQuery(builderFactory.matchAllBuilder.build()),
                    ).collect { habits ->
                        _hasAnyHabits.value = habits.isEmpty().not()
                    }
            }
    }
