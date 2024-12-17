package com.habithatch.demo.core.util

import com.habithatch.demo.data.entities.GoalPriority

private fun GoalPriority?.orElse(default: GoalPriority): GoalPriority {
    return this ?: default
}

fun GoalPriority.getHigherPriorityOrLowest(priorities: List<GoalPriority>): GoalPriority {
    val nextHigher = priorities.sorted().find { it.importance >= this.importance }
    return nextHigher.orElse(priorities.first())
}
