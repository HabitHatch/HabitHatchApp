package com.habithatch.demo.core.exceptions

class InvalidGoalFilterException(
    message: String,
) : IllegalArgumentException(
        "Invalid GoalFilter:  $message",
    )
