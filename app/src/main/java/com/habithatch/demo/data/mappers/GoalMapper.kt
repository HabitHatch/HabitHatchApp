package com.habithatch.demo.data.mappers

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.models.GoalModel
import java.util.Date
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
                title = goal.title,
                statusLabel = goal.status.label,
                priorityLabel = goal.priority.label,
                createdAt = goal.createdAt ?: Date(),
            )

        fun fromEntity(entity: GoalEntity): GoalModel {
            val priority = priorityProvider.getPriorityByLabel(entity.priorityLabel)
            val status = statusProvider.getStatusByLabel(entity.statusLabel)
            return GoalModel(
                id = entity.id,
                title = entity.title,
                status = status,
                priority = priority,
                createdAt = entity.createdAt,
            )
        }
    }
