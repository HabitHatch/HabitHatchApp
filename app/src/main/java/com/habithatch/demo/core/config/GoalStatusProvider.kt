package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.GoalModel

interface GoalStatusProvider {
    val statuses: Set<GoalModel.Status>
    val defaultStatus: GoalModel.Status

    @Throws(NoSuchElementException::class)
    fun getStatusByLabel(statusLabel: String): GoalModel.Status = statuses.first { it.label == statusLabel }
}
