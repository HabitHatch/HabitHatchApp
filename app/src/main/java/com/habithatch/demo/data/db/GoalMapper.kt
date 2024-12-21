package com.habithatch.demo.data.db

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.data.entities.GoalEntity
import com.habithatch.demo.data.models.GoalModel

class GoalMapper @Inject constructor(private val config: HabitHatchConfig) {

    fun toEntity(goal: GoalModel): GoalEntity {
        return GoalEntity(
                id = goal.id,
                title = goal.title,
                statusId = goal.status.id,
                priorityId = goal.priority.id
        )
    }

    fun fromEntity(entity: GoalEntity): GoalModel {
        val priority = config.getPriorityById(entity.priorityId)
        val status = config.getStatusById(entity.statusId)
        return GoalModel(
                id = entity.id,
                title = entity.title,
                status = status,
                priority = priority
        )
    }
}
