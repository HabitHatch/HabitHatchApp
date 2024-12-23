package com.habithatch.demo.core.exceptions

class GoalNotFoundException(
    goalId: Int,
) : IllegalArgumentException(
        "Goal with ID $goalId not found",
    )
