package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.HabitModel

/** Provides the priorities for habits. */
interface HabitPriorityProvider {
    val priorities: Set<HabitModel.Priority>
    val defaultPriority: HabitModel.Priority

    @Throws(NoSuchElementException::class)
    fun getPriorityByLabel(priorityLabel: String) = priorities.first { it.label == priorityLabel }
}
