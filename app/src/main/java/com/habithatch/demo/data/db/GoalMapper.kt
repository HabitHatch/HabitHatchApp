package com.habithatch.demo.data.db

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.models.Goal

class GoalMapper @Inject constructor(private val config: HabitHatchConfig) {

    fun toEntity(goal: Goal): GoalEntity {
        return GoalEntity(
                id = goal.id,
                title = goal.title,
                statusId = goal.status.id,
                priorityId = goal.priority.id
        )
    }

    fun fromEntity(entity: GoalEntity): Goal {
        val priority = config.getPriorityById(entity.priorityId)
        val status = config.getStatusById(entity.statusId)
        if (priority == null || status == null) {
            throw IllegalArgumentException("Invalid priority or status id")
        }
        return Goal(
                id = entity.id,
                title = entity.title,
                status = status,
                priority = priority
        )
    }
}
