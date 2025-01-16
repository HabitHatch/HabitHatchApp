package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.HabitModel

/**
 * Returns the alpha factor for the priority. Used to give more weight to high importance habits.
 *
 * @return The alpha factor.
 */
fun HabitModel.Priority.getAlphaFactor(): Float =
    when {
        isImportant() -> 2f
        else -> 1f
    }
