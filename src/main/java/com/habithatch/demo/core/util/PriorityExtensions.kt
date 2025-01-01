package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.GoalModel

/**
 * Returns the alpha factor for the priority. Used to give more weight to high importance goals.
 *
 * @return The alpha factor.
 */
fun GoalModel.Priority.getAlphaFactor(): Float =
    when {
        isImportant() -> 2f
        else -> 1f
    }
