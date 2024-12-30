package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.config.GoalStatusProvider
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
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class GoalRepository
    @Inject
    constructor(
        private val goalDao: GoalDao,
        private val statusesProvider: GoalStatusProvider,
        private val goalMapper: GoalMapper,
        userRepository: UserRepository,
    ) {
        private val currentUserFlow = userRepository.getUser()

        private suspend fun asEntity(goalModel: GoalModel): GoalEntity {
            val currentUser = currentUserFlow.firstOrNull()
            checkNotNull(currentUser) { "User must be created before inserting goals" }
            return goalMapper.asEntity(goalModel, currentUser.uuid)
        }

        fun getAll(): Flow<Collection<GoalModel>> =
            goalDao.getAll().map { goals ->
                goals.map(goalMapper::asModel)
            }

        suspend fun insert(goal: GoalModel) {
            goalDao.insert(asEntity(goal))
        }

        suspend fun deleteAll() = goalDao.deleteAll()

        @Throws(IllegalArgumentException::class)
        suspend fun cycleGoalStatus(goalModel: GoalModel) {
            val nextStatusInCycle =
                statusesProvider.statuses.getNextHigherOrLowest(
                    bySelector = { it.stepNumber },
                    element = goalModel.status,
                )
            this.update(goalModel.copy(status = nextStatusInCycle))
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        fun getQueriedGoals(goalQuery: GoalQuery): Flow<List<GoalModel>> =
            getFilteredGoals(goalQuery.filter)
                .combine(flowOf(goalQuery.getComparator())) { goals, comparator ->
                    goals.sortedWith(comparator)
                }

        suspend fun insertAll(goals: Collection<GoalModel>) {
            goalDao.insertAll(
                goals.map {
                    asEntity(it)
                },
            )
        }

        private suspend fun update(goal: GoalModel) {
            val goalEntity = asEntity(goal)
            goalDao.update(
                id = goalEntity.id,
                title = goalEntity.title,
                statusLabel = goalEntity.statusLabel,
                priorityLabel = goalEntity.priorityLabel,
            )
        }

        private fun getFilteredGoals(goalFilter: GoalFilter): Flow<Collection<GoalModel>> =
            this
                .getAll()
                .map { allGoals ->
                    allGoals.filter(goalFilter::isMatch)
                }
    }
