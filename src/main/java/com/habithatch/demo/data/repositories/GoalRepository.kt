package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.query.GoalFilter
import com.habithatch.demo.core.query.GoalQuery
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.mappers.GoalMapper
import com.habithatch.demo.data.models.GoalModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

/** [GoalRepository] is a repository that provides access to goals in the database. */
class GoalRepository
    @Inject
    constructor(
        private val goalDao: GoalDao,
        private val goalMapper: GoalMapper,
    ) {
        /** Inserts the given goals into the database. */
        suspend fun insert(vararg goals: GoalModel) {
            goals.forEach { goal ->
                goalDao.insert(goalMapper.asEntity(goal))
            }
        }

        fun getAll() = goalDao.getAll().map { it.map(goalMapper::asModel) }

        /** Returns a flow of goals that match the given [GoalQuery]. Sorted by GoalQuery's comparator. */
        @OptIn(ExperimentalCoroutinesApi::class)
        fun search(query: GoalQuery): Flow<List<GoalModel>> =
            getFilteredGoals(query.filter)
                .combine(flowOf(query.getComparator())) { goals, comparator ->
                    goals.sortedWith(comparator)
                }

        /** Updates the given goal in the database. */
        suspend fun update(goal: GoalModel) {
            val goalEntity = goalMapper.asEntity(goal)
            goalDao.update(
                id = goalEntity.id,
                title = goalEntity.title,
                statusLabel = goalEntity.statusLabel,
                priorityLabel = goalEntity.priorityLabel,
            )
        }

        /** Deletes all goals permanently from the database. */
        suspend fun deleteAll() = goalDao.deleteAll()

        private fun getFilteredGoals(goalFilter: GoalFilter) = this.getAll().map { it.filter(goalFilter::isMatch) }
    }
