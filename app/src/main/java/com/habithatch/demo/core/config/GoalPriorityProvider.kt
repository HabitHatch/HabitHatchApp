package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.GoalModel

interface GoalPriorityProvider {
    val priorities: List<GoalModel.Priority>
    val defaultPriority: GoalModel.Priority

    @Throws(NoSuchElementException::class)
    fun getPriorityByLabel(priorityLabel: String): GoalModel.Priority {
        return priorities.first { it.label == priorityLabel }
    }
}