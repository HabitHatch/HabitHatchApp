package com.habithatch.demo.data.models

import com.habithatch.demo.core.config.GoalPriorityProvider
import com.habithatch.demo.core.config.GoalStatusProvider
import com.habithatch.demo.core.util.createRandomDate

val habitNames =
    setOf(
        "Morning Meditation",
        "Read 30 Minutes",
        "Daily Workout",
        "Write Journal Entry",
        "Learn a New Skill",
        "Walk 10,000 Steps",
        "Drink 2L Water",
        "Plan Tomorrow's Tasks",
        "Spend Time with Family",
        "Declutter Workspace",
    )

class ExampleGoalFactory(
    private val priorityProvider: GoalPriorityProvider,
    private val statusProvider: GoalStatusProvider,
) {
    fun randomPriority() = priorityProvider.priorities.random()

    fun randomStatus() = statusProvider.statuses.random()

    fun createGoalModel(): GoalModel =
        GoalModel(
            title = habitNames.random(),
            status = randomStatus(),
            priority = randomPriority(),
            createdAt = createRandomDate(),
        )
}
