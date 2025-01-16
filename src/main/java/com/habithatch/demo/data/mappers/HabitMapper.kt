package com.habithatch.demo.data.mappers

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import com.habithatch.demo.data.entities.HabitEntity
import com.habithatch.demo.data.models.HabitModel

/**
 * [HabitMapper] is a mapper that maps [HabitModel] to [HabitEntity] and vice versa.
 * [HabitEntity] is a RoomEntity, used for storing habits in the database.
 * [HabitModel] is a model used for creating and displaying habits.
 */
class HabitMapper
    @Inject
    constructor(
        private val statusProvider: HabitStatusProvider,
        private val priorityProvider: HabitPriorityProvider,
        private val habitModelFactory: HabitModel.Factory,
    ) {
        /**
         * Maps a [HabitModel] to a [HabitEntity].
         * Every Habit in the Database needs to have a createdAt date.
         * If the habit is a draft, the createdAt date is set to the current date.
         */
        @Throws(IllegalArgumentException::class)
        fun asEntity(
            habit: HabitModel,
        ): HabitEntity {
            require(habit.isDraft || habit.createdAt != null) {
                "createdAt must not be null for non-draft habits $habit"
            }
            return HabitEntity(
                    id = habit.getUniqueId(),
                    userId = habit.userId,
                    title = habit.title,
                    statusLabel = habit.status.label,
                    priorityLabel = habit.priority.label,
                    createdAt = habit.getCreatedAtOrNow(),
            )
        }

        @Throws(NoSuchElementException::class)
        fun asModel(entity: HabitEntity): HabitModel =
            habitModelFactory.createFromEntity(
                entity = entity,
                status = statusProvider.getStatusByLabel(entity.statusLabel),
                priority = priorityProvider.getPriorityByLabel(entity.priorityLabel),
            )
    }
