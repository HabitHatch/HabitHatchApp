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
    private val goalModelFactory: GoalModel.Factory,
) {
    fun randomPriority() = priorityProvider.priorities.random()

    fun randomStatus() = statusProvider.statuses.random()

    fun createExampleGoal(
        pastYears: Long = 1,
    ): GoalModel =
        goalModelFactory.createExample(
            title = habitNames.random(),
            status = randomStatus(),
            priority = randomPriority(),
            createdAt = createRandomDate(pastYears),
        )

    fun createExampleGoals(
        count: Int,
        pastYears: Long = 1,
        uniqueTitles: Boolean = false,
    ): Collection<GoalModel> {
        val generatedGoals = mutableSetOf<GoalModel>()
        val getUsedTitles = { generatedGoals.map { it.title }.toSet() }
        require(!uniqueTitles || count <= habitNames.size) {
            "Cannot generate more goals than there are unique habit names"
        }

        repeat(count) {
            var goal = createExampleGoal(pastYears)

            while (uniqueTitles && getUsedTitles().contains(goal.title)) {
                goal = createExampleGoal(pastYears)
            }
            generatedGoals.add(goal)
        }
        return generatedGoals
    }
}
