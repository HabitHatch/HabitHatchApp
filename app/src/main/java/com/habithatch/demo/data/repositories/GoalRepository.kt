package com.habithatch.demo.data.repositories

import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.Goal
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.models.GoalFilter
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
                    status = if (it.status == GoalStatus.DONE) GoalStatus.UNDONE else GoalStatus.DONE
            )
            goalDao.update(goal)
        }
    }

    fun getFilteredGoals(filter: GoalFilter): Flow<List<Goal>> {
        return goalDao.getAll().map { allGoals ->
            allGoals.filter { goal ->
                val matchesDone = filter.goalStatusVisibleMap[goal.status] == true
                val matchesPriority = filter.goalPriorityVisibleMap[goal.priority] == true
                val matchesSearch = filter.searchQuery.isNullOrBlank() ||
                        goal.title.contains(filter.searchQuery, ignoreCase = true)

                matchesDone && matchesPriority && matchesSearch
            }
        }
    }

    suspend fun seedDatabase() {
        if (getAll().firstOrNull().isNullOrEmpty()) {
            val goals = listOf(
                    Goal(id = 1, title = "Drink water", status = GoalStatus.UNDONE),
                    Goal(id = 2, title = "Read a book", status = GoalStatus.UNDONE),
                    Goal(id = 3, title = "Exercise", status = GoalStatus.DONE)
            )
            goals.forEach { insert(it) }
        }
    }
}