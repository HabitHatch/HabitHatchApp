package com.habithatch.demo.data.repositories

import com.habithatch.demo.core.query.HabitFilter
import com.habithatch.demo.core.query.HabitQuery
import com.habithatch.demo.data.daos.HabitDao
import com.habithatch.demo.data.entities.HabitEntity
import com.habithatch.demo.data.mappers.HabitMapper
import com.habithatch.demo.data.models.HabitModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

/**
 * [HabitRepository] is a repository that provides access to habits in the database.
 */
class HabitRepository
    @Inject
    constructor(
        private val habitDao: HabitDao,
        private val habitMapper: HabitMapper,
        userRepository: UserRepository,
    ) {
        private val currentUser = userRepository.getUser()

        /**
         * Inserts the given habits into the database.
         */
        suspend fun insert(vararg habits: HabitModel) {
            habits.forEach { habit ->
                habitDao.insert(asEntity(habit))
            }
        }

        /**
         * Returns a flow of habits that match the given [HabitQuery].
         * Sorted by HabitQuery's comparator.
         */
        @OptIn(ExperimentalCoroutinesApi::class)
        fun getQueriedHabits(query: HabitQuery): Flow<List<HabitModel>> =
            getFilteredHabits(query.filter)
                .combine(flowOf(query.getComparator())) { habits, comparator ->
                    habits.sortedWith(comparator)
                }

        /**
         * Updates the given habit in the database.
         */
        suspend fun update(habit: HabitModel) {
            val habitEntity = asEntity(habit)
            habitDao.update(
                id = habitEntity.id,
                title = habitEntity.title,
                statusLabel = habitEntity.statusLabel,
                priorityLabel = habitEntity.priorityLabel,
            )
        }

        /**
         * Deletes all habits permanently from the database.
         */
        suspend fun deleteAll() = habitDao.deleteAll()

        private fun getFilteredHabits(habitFilter: HabitFilter) = this.getAll().map { it.filter(habitFilter::isMatch) }

        private fun getAll() = habitDao.getAll().map { it.map(habitMapper::asModel) }

        private suspend fun asEntity(habitModel: HabitModel): HabitEntity {
            val currentUser = currentUser.firstOrNull()
            checkNotNull(currentUser) { "User must be created before inserting habits" }
            return habitMapper.asEntity(habitModel, currentUser.uuid)
        }
    }
