package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.GoalModel

/**
 * Provides the statuses for goals.
 */
interface GoalStatusProvider {
    val statuses: Set<GoalModel.Status>
    val defaultStatus: GoalModel.Status

    @Throws(NoSuchElementException::class)
    fun getStatusByLabel(statusLabel: String): GoalModel.Status = statuses.first { it.label == statusLabel }
}
