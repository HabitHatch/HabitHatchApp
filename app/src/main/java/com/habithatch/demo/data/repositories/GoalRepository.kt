package com.habithatch.demo.data.repositories

import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.models.GoalFilter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GoalRepository(private val goalDao: GoalDao) {
    fun getAll(): Flow<List<Goal>> = goalDao.getAll()

    suspend fun insert(goal: Goal)  = goalDao.insert(goal)

    suspend fun toggleGoalDone(goalId: Int) {
        goalDao.getGoalById(goalId)?.let {
            val goal = it.copy(isDone = !it.isDone)
            goalDao.update(goal)
        }
    }

    fun getFilteredGoals(filter: GoalFilter): Flow<List<Goal>> {
        return goalDao.getAll().map { allGoals->
            allGoals.filter { goal ->
                val matchesDone = filter.isDone == null || goal.isDone == filter.isDone
                val matchesPriority = filter.possiblePriorities.contains(goal.priority)
                val matchesSearch = filter.searchQuery.isNullOrBlank() ||
                        goal.title.contains(filter.searchQuery, ignoreCase = true)

                matchesDone && matchesPriority && matchesSearch
            }
        }
    }
}