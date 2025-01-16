package com.habithatch.demo.data.mappers

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.models.GoalModel
import javax.inject.Inject

/**
 * [GoalMapper] is a mapper that maps [GoalModel] to [GoalEntity] and vice versa.
 * [GoalEntity] is a RoomEntity, used for storing goals in the database.
 * [GoalModel] is a model used for creating and displaying goals.
 */
class GoalMapper
    @Inject
    constructor(
        private val statusProvider: GoalStatusProvider,
        private val priorityProvider: GoalPriorityProvider,
        private val goalModelFactory: GoalModel.Factory,
    ) {
        /**
         * Maps a [GoalModel] to a [GoalEntity].
         * Every Goal in the Database needs to have a createdAt date.
         * If the goal is a draft, the createdAt date is set to the current date.
         */
        @Throws(IllegalArgumentException::class)
        fun asEntity(
            goal: GoalModel,
        ): GoalEntity {
            require(goal.isDraft || goal.createdAt != null) {
                "createdAt must not be null for non-draft goals $goal"
            }
            return GoalEntity(
                id = goal.getUniqueId(),
                userId = goal.userId,
                title = goal.title,
                statusLabel = goal.status.label,
                priorityLabel = goal.priority.label,
                createdAt = goal.getCreatedAtOrNow(),
            )
        }

        @Throws(NoSuchElementException::class)
        fun asModel(entity: GoalEntity): GoalModel =
            goalModelFactory.createFromEntity(
                entity = entity,
                status = statusProvider.getStatusByLabel(entity.statusLabel),
                priority = priorityProvider.getPriorityByLabel(entity.priorityLabel),
            )
    }
