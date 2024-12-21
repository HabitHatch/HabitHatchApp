package com.habithatch.demo.core.config

import kotlin.jvm.Throws
import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.data.models.GoalQuery

interface HabitHatchConfig {
    val pets: List<Pet>
    val exampleGoals: List<GoalModel>
    val navigationItems: List<NavigationItem>
    val accountItem: NavigationItem
    val priorities: List<GoalModel.Priority>
    val defaultPriority: GoalModel.Priority
    val statuses: List<GoalModel.Status>
    val defaultStatus: GoalModel.Status
    fun getDefaultGoalQuery(): GoalQuery

    @Throws(NoSuchElementException::class)
    fun getPriorityById(priorityId: String): GoalModel.Priority {
        return priorities.first { it.id == priorityId }
    }

    @Throws(NoSuchElementException::class)
    fun getStatusById(statusId: String): GoalModel.Status {
        return statuses.first { it.id == statusId }
    }
}