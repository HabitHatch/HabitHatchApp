package com.habithatch.demo.data.repositories

import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.Goal
import kotlinx.coroutines.flow.Flow


class GoalRepository(private val goalDao: GoalDao) {
    fun getAll(): Flow<List<Goal>> = goalDao.getAll()

    fun getAllActive(): Flow<List<Goal>> = goalDao.getAllActive()

    suspend fun insert(goal: Goal) {
        goalDao.insert(goal)
    }

    suspend fun markGoalHasDone(goalId: Int) {
        goalDao.getGoalById(goalId)?.let {
            val goal = it.copy(isDone = true)
            goalDao.update(goal)
        }
    }
}