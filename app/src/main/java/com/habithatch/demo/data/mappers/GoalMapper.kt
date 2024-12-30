package com.habithatch.demo.data.mappers

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.models.GoalModel
import java.time.Instant
import java.util.UUID
import javax.inject.Inject

class GoalMapper
    @Inject
    constructor(
        private val statusProvider: GoalStatusProvider,
        private val priorityProvider: GoalPriorityProvider,
        private val goalModelFactory: GoalModel.Factory,
    ) {
        @Throws(IllegalArgumentException::class)
        fun asEntity(
            goal: GoalModel,
            userId: UUID,
        ): GoalEntity {
            require(goal.isDraft || goal.createdAt != null) {
                "createdAt must not be null for non-draft goals"
            }
            return GoalEntity(
                id = goal.getUniqueId(),
                userId = userId,
                title = goal.title,
                statusLabel = goal.status.label,
                priorityLabel = goal.priority.label,
                createdAt = goal.createdAt ?: Instant.now(),
            )
        }

        fun asModel(entity: GoalEntity): GoalModel =
            goalModelFactory.createFromEntity(
                entity = entity,
                status = statusProvider.getStatusByLabel(entity.statusLabel),
                priority = priorityProvider.getPriorityByLabel(entity.priorityLabel),
            )
    }
