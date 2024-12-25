package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.exceptions.GoalNotFoundException
import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class GoalRepository
    @Inject
    constructor(
        private val goalDao: GoalDao,
        private val statusesProvider: GoalStatusProvider,
        private val goalMapper: GoalMapper,
    ) {
        fun getAll(): Flow<Collection<GoalModel>> =
            goalDao.getAll().map { goals ->
                goals.map(goalMapper::fromEntity)
            }

        suspend fun insert(goal: GoalModel) {
            goalDao.insert(this.goalMapper.toEntity(goal))
        }

        suspend fun deleteAll() = goalDao.deleteAll()

        @Throws(GoalNotFoundException::class)
        suspend fun changeGoalStatusToNextInCycle(goalId: Int) {
            val goalModel = getById(goalId).first()
            val nextStatusInCycle =
                statusesProvider.statuses.getNextHigherOrLowest(
                    bySelector = { it.stepNumber },
                    element = goalModel.status,
                )
            val newGoalModel = goalModel.copy(status = nextStatusInCycle)
            this.update(newGoalModel)
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        fun getQueriedGoals(goalQuery: GoalQuery): Flow<List<GoalModel>> =
            getFilteredGoals(goalQuery.filter)
                .combine(flowOf(goalQuery.getComparator())) { goals, comparator ->
                    goals.sortedWith(comparator)
                }

        suspend fun insertAll(goals: Collection<GoalModel>) {
            goalDao.insertAll(goals.map(goalMapper::toEntity))
        }

        private suspend fun update(goal: GoalModel) {
            val goalEntity = goalMapper.toEntity(goal)
            goalDao.update(
                id = goalEntity.id,
                title = goalEntity.title,
                statusLabel = goalEntity.statusLabel,
                priorityLabel = goalEntity.priorityLabel,
            )
        }

        @Throws(GoalNotFoundException::class)
        private fun getById(goalId: Int): Flow<GoalModel> {
            val goalEntityFlow: Flow<GoalEntity?> = goalDao.getGoalById(goalId)
            return goalEntityFlow.map { goalEntity ->
                if (goalEntity == null) {
                    throw GoalNotFoundException(goalId)
                }
                goalMapper.fromEntity(goalEntity)
            }
        }

        private fun getFilteredGoals(goalFilter: GoalFilter): Flow<Collection<GoalModel>> =
            this
                .getAll()
                .map { allGoals ->
                    allGoals.filter(goalFilter::isMatch)
                }
    }
