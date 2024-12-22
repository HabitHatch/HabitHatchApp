package com.habithatch.demo.core.exceptions

import com.habithatch.demo.data.models.GoalFilter

class InvalidGoalFilterException(message: String) : IllegalArgumentException(
        "Invalid GoalFilter:  $message"
)