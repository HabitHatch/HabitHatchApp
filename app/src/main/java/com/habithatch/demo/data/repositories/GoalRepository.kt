package com.habithatch.demo.data.repositories

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.exceptions.GoalNotFoundException
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalFilter
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class GoalRepository @Inject constructor(
    private val goalDao: GoalDao,
    private val config: HabitHatchConfig,
    private val goalMapper: GoalMapper
) {
    fun getAll(): Flow<Collection<GoalModel>> {
        return goalDao.getAll().map { goals ->
            goals.map(goalMapper::fromEntity)
        }
    }

    suspend fun insert(goal: GoalModel) {
        goalDao.insert(this.goalMapper.toEntity(goal))
    }

    suspend fun deleteAll() = goalDao.deleteAll()

    @Throws(GoalNotFoundException::class)
    suspend fun changeGoalStatusToNextInCycle(goalId: Int) {
       val goalModel = getById(goalId).first()
        val nextStatusInCycle = config.statuses.getNextHigherOrLowest(
                bySelector = { it.stepNumber },
                element = goalModel.status
        )
        val newGoalModel = goalModel.updateStatus(nextStatusInCycle)
        this.update(newGoalModel)
    }

    fun getQueriedGoals(goalQuery: GoalQuery): Flow<List<GoalModel>> {
        return getFilteredGoals(goalQuery.filter).map { goals ->
            goals.sortedWith(goalQuery.getSortConfig().comparator)
        }
    }

    fun insertAll(goals: Collection<GoalModel>) {
        goals
            .map(goalMapper::toEntity)
            .forEach { goalDao::insert }
    }

    private suspend fun update(goal: GoalModel) {
        goalDao.update(goalMapper.toEntity(goal))
    }


    @Throws(GoalNotFoundException::class)
    private fun getById(goalId: Int): Flow<GoalModel> {
        return goalDao.getGoalById(goalId)
            .map { goalEntity ->
                if (goalEntity == null) {
                    throw GoalNotFoundException(goalId)
                }
                goalMapper.fromEntity(goalEntity)
            }
    }

    private fun getFilteredGoals(goalFilter: GoalFilter): Flow<Collection<GoalModel>> {
        return this.getAll()
            .map { allGoals ->
                allGoals.filter(goalFilter::isMatch)
            }
    }
}