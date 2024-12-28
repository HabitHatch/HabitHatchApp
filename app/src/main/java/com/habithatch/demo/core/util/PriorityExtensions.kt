package com.habithatch.demo.core.util

import com.habithatch.demo.data.models.GoalModel

fun GoalModel.Priority.getAlphaFactor(): Float =
    when {
        hasHighImportance() -> 2f
        else -> 1f
    }
