package com.habithatch.demo.data.models

import java.util.UUID
import com.habithatch.demo.core.config.HabitPriorityProvider
import com.habithatch.demo.core.config.HabitStatusProvider
import com.habithatch.demo.core.util.createRandomDate

/**
 * @suppress
 */
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
        "Review Personal Habits",
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

/**
 * [ExampleHabitFactory] is a factory that creates example habits for testing purposes.
 */
class ExampleHabitFactory(
    private val priorityProvider: HabitPriorityProvider,
    private val statusProvider: HabitStatusProvider,
    private val habitModelFactory: HabitModel.Factory,
) {
    fun createExampleHabits(
        count: Int,
        userId: UUID,
        pastYears: Long = 1,
        uniqueTitles: Boolean = false,
    ): Collection<HabitModel> {
        val generatedHabits = mutableSetOf<HabitModel>()
        val getUsedTitles = { generatedHabits.map { it.title }.toSet() }
        require(!uniqueTitles || count <= habitNames.size) {
            "Cannot generate more habits than there are unique habit names"
        }
        repeat(count) {
            var habit: HabitModel

            do {
                habit = createExampleHabit(userId, pastYears)
            } while (uniqueTitles && getUsedTitles().contains(habit.title))
            generatedHabits.add(habit)
        }
        return generatedHabits
    }

    private fun randomPriority() = priorityProvider.priorities.random()

    private fun randomStatus() = statusProvider.statuses.random()

    private fun createExampleHabit(
        userId: UUID,
        pastYears: Long = 1,
    ): HabitModel =
        habitModelFactory.createDraft(
            userId = userId,
            title = habitNames.random(),
            status = randomStatus(),
            priority = randomPriority(),
            createdAt = createRandomDate(pastYears),
        )
}
