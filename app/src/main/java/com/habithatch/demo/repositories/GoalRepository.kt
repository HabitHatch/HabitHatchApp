package com.habithatch.demo.repositories

import com.habithatch.demo.daos.GoalDao
import com.habithatch.demo.entities.Goal


class GoalRepository(private val goalDao: GoalDao) {
    suspend fun getAll(): List<Goal> {
        return goalDao.getAll()
    }

    suspend fun getAllActive(): List<Goal> {
        return goalDao.getAllActive()
    }

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