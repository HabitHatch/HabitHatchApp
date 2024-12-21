package com.habithatch.demo.data.repositories

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.util.getNextHigherOrLowest
import com.habithatch.demo.data.daos.GoalDao
import com.habithatch.demo.data.db.GoalMapper
import com.habithatch.demo.data.models.GoalFilterAttributes
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map


class GoalRepository @Inject constructor(
    private val goalDao: GoalDao,
    private val config: HabitHatchConfig,
    private val goalMapper: GoalMapper
) {
    fun getAll(): Flow<List<GoalModel>> {
        return goalDao.getAll().map { goals ->
            goals.map { goalMapper.fromEntity(it) }
        }
    }

    suspend fun insert(goal: GoalModel) {
        goalDao.insert(this.goalMapper.toEntity(goal))
    }

    suspend fun deleteAll() = goalDao.deleteAll()

    suspend fun changeGoalStatusToNextInCycle(goalId: Int) {
        goalDao.getGoalById(goalId)?.let { goalEntity ->
            val goalModel = goalMapper.fromEntity(goalEntity)
            val nextStatusInCycle = config.statuses.getNextHigherOrLowest(
                    { a, b -> a.stepNumber.compareTo(b.stepNumber) },
                    goalModel.status
            )
            val newGoalModel = goalModel.copy(
                    status = nextStatusInCycle
            )
            val newGoalEntity = goalMapper.toEntity(newGoalModel)
            goalDao.update(newGoalEntity)
        }
    }

    private fun getFilteredGoals(
        goalFilter: GoalFilterAttributes
    ): Flow<List<GoalModel>> {
        return goalDao.getAll().map { allGoals ->
            allGoals
                .map { goalMapper.fromEntity(it) }
                .filter { goalModel ->
                    val matchesDone = goalFilter.statusVisibleMap[goalModel.status] == true
                    val matchesPriority =
                        goalFilter.priorityVisibleMap[goalModel.priority] == true
                    val matchesSearch = goalFilter.searchQuery.isNullOrBlank() ||
                            goalModel.title.contains(
                                    goalFilter.searchQuery,
                                    ignoreCase = true
                            )

                    matchesDone && matchesPriority && matchesSearch
                }
        }
    }

    fun getQueriedGoals(goalQuery: GoalQuery): Flow<List<GoalModel>> {
        return getFilteredGoals(goalQuery.filterAttributes).map { goals ->
            goals.sortedWith(goalQuery.sortConfig.getEffectiveComparator())
        }
    }

    suspend fun seedDatabase() {
        if (getAll().firstOrNull().isNullOrEmpty()) {
            config.exampleGoals
                .map { goalMapper.toEntity(it) }
                .forEach { goalDao.insert(it) }
        }
    }
}