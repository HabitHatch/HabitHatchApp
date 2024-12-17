package com.habithatch.demo.data.repositories

import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.models.GoalFilterAttributes
import com.habithatch.demo.data.models.GoalQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map


class GoalRepository(private val goalDao: GoalDao) {
    fun getAll(): Flow<List<Goal>> = goalDao.getAll()

    suspend fun insert(goal: Goal) = goalDao.insert(goal)

    suspend fun deleteAll() = goalDao.deleteAll()

    suspend fun toggleGoalDone(goalId: Int) {
        goalDao.getGoalById(goalId)?.let {
            val goal = it.copy(
                    status = if (it.status == GoalStatus.DONE) GoalStatus.IN_PROGRESS else GoalStatus.DONE
            )
            goalDao.update(goal)
        }
    }

    private fun getFilteredGoals(
        goalFilter: GoalFilterAttributes
    ): Flow<List<Goal>> {
        return goalDao.getAll().map { allGoals ->
            allGoals.filter { goal ->
                val matchesDone = goalFilter.goalStatusVisibleMap[goal.status] == true
                val matchesPriority = goalFilter.goalPriorityVisibleMap[goal.priority] == true
                val matchesSearch = goalFilter.searchQuery.isNullOrBlank() ||
                        goal.title.contains(goalFilter.searchQuery, ignoreCase = true)

                matchesDone && matchesPriority && matchesSearch
            }
        }
    }

    fun getQueriedGoals(goalQuery: GoalQuery): Flow<List<Goal>> {
        return getFilteredGoals(goalQuery.filterConfig).map { goals ->
            goals.sortedWith(goalQuery.sortConfig.getEffectiveComparator())
        }
    }

    suspend fun seedDatabase() {
        if (getAll().firstOrNull().isNullOrEmpty()) {

            goals.forEach { insert(it) }
        }
    }
}