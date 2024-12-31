package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.GoalModel

/**
 * Provides the priorities for goals.
 */
interface GoalPriorityProvider {
    val priorities: Set<GoalModel.Priority>
    val defaultPriority: GoalModel.Priority

    @Throws(NoSuchElementException::class)
    fun getPriorityByLabel(priorityLabel: String): GoalModel.Priority = priorities.first { it.label == priorityLabel }
}
