package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.HabitModel

/**
 * Provides the statuses for habits.
 */
interface HabitStatusProvider {
    val statuses: Set<HabitModel.Status>
    val defaultStatus: HabitModel.Status

    @Throws(NoSuchElementException::class)
    fun getStatusByLabel(statusLabel: String): HabitModel.Status = statuses.first { it.label == statusLabel }
}
