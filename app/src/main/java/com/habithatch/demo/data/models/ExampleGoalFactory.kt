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
        "Practice Gratitude",
        "Limit Social Media to 30 Minutes",
        "Eat 5 Servings of Vegetables",
        "Stretch for 10 Minutes",
        "Practice Deep Breathing",
        "Review Personal Goals",
        "Listen to an Educational Podcast",
        "Unplug 1 Hour Before Bed",
        "Track Expenses",
        "Compliment Someone",
        "Write Down 3 Things You're Grateful For",
        "Avoid Sugar for a Day",
        "Read or Watch News Mindfully",
        "Practice a Hobby",
        "Spend Time in Nature",
        "Complete One Difficult Task First",
        "Limit Caffeine Intake",
        "Meal Prep for the Week",
        "Sleep 7-8 Hours",
        "Reflect on the Day Before Bed",
    )

class ExampleGoalFactory(
    private val priorityProvider: GoalPriorityProvider,
    private val statusProvider: GoalStatusProvider,
) {
    fun randomPriority() = priorityProvider.priorities.random()

    fun randomStatus() = statusProvider.statuses.random()

    fun createExampleGoal(
        pastYears: Long = 1,
    ): GoalModel =
        GoalModel(
            title = habitNames.random(),
            status = randomStatus(),
            priority = randomPriority(),
            createdAt = createRandomDate(pastYears),
        )

    fun createExampleGoals(
        count: Int,
        pastYears: Long = 1,
        uniqueTitle: Boolean = false,
    ): Collection<GoalModel> {
        val generatedGoals = mutableSetOf<GoalModel>()
        val usedTitles = mutableSetOf<String>()
        require(!uniqueTitle || count <= habitNames.size) {
            "Cannot generate more goals than there are unique habit names"
        }

        repeat(count) {
            var goal = createExampleGoal(pastYears)

            while (uniqueTitle && usedTitles.contains(goal.title)) {
                goal = createExampleGoal(pastYears)
            }
            generatedGoals.add(goal)
        }
        return generatedGoals
    }
}
