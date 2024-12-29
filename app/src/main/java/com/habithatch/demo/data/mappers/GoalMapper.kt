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
    ) {
        fun toEntity(goal: GoalModel): GoalEntity =
            GoalEntity(
                id = goal.id,
                userId = goal.userId ?: UUID.randomUUID(),
                title = goal.title,
                statusLabel = goal.status.label,
                priorityLabel = goal.priority.label,
                createdAt = goal.createdAt ?: Instant.now(),
            )

        fun fromEntity(entity: GoalEntity): GoalModel {
            val priority = priorityProvider.getPriorityByLabel(entity.priorityLabel)
            val status = statusProvider.getStatusByLabel(entity.statusLabel)
            return GoalModel(
                id = entity.id,
                userId = entity.userId,
                title = entity.title,
                status = status,
                priority = priority,
                createdAt = entity.createdAt,
            )
        }
    }
