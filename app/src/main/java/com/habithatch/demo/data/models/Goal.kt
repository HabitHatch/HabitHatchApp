package com.habithatch.demo.data.models

import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus

data class Goal(
    val id: Int = 0,
    val title: String,
    val status: GoalStatus,
    val priority: GoalPriority
)
