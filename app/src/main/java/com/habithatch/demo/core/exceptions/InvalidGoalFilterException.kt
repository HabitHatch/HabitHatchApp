package com.habithatch.demo.core.exceptions

import com.habithatch.demo.data.models.GoalFilter

class InvalidGoalFilterException(goalFilter: GoalFilter, message: String) : IllegalArgumentException(
        "Invalid GoalFilter: $goalFilter $message"
)