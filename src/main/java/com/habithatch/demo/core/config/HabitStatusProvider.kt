package com.habithatch.demo.core.config

import com.habithatch.demo.data.models.HabitModel

/**
 * Provides the statuses for habits.
 */
interface HabitStatusProvider {
    val statuses: Set<HabitModel.Status>
    val defaultStatus: HabitModel.Status

    @Throws(NoSuchElementException::class)
    fun getStatusById(statusId: Int): HabitModel.Status = statuses.first { it.id == statusId }
}
