package com.habithatch.demo.data.entities

import javax.inject.Inject
import com.habithatch.demo.core.config.HabitHatchConfig

class GoalBuilder @Inject constructor(private val config: HabitHatchConfig) {
    private var title: String = ""
    private var status: GoalStatus = GoalStatus.IN_PROGRESS
    private var priorityId: String = config.defaultPriority.id

    fun setTitle(title: String): GoalBuilder {
        this.title = title
        return this
    }

    fun setStatus(status: GoalStatus): GoalBuilder {
        this.status = status
        return this
    }

    fun setPriority(priority: GoalPriority): GoalBuilder {
        this.priorityId = priority.id
        return this
    }

    fun setPriorityById(priorityId: String): GoalBuilder {
        this.priorityId = priorityId
        return this
    }

    fun build(): Goal {
        require(title.isNotBlank()) { "Title must not be empty or blank." }
        require(title.length <= 50) { "Title must not exceed 50 characters." }

        val validPriority = config.priorities.any { it.id == priorityId }
        require(validPriority) { "Invalid priority ID: $priorityId" }

        return Goal(
                title = title,
                status = status,
                priorityId = priorityId
        )
    }
}
