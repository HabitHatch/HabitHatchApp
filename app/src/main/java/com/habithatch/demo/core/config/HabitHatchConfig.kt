package com.habithatch.demo.core.config

import com.habithatch.demo.core.navigation.NavigationItem
import com.habithatch.demo.data.entities.GoalPriority
import com.habithatch.demo.data.entities.GoalStatus
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.models.Goal
import com.habithatch.demo.data.models.GoalQuery

interface HabitHatchConfig {
    val pets: List<Pet>
    val exampleGoals: List<Goal>
    val navigationItems: List<NavigationItem>
    val accountItem: NavigationItem
    val defaultGoalQuery: GoalQuery
    val priorities: List<GoalPriority>
    val defaultPriority: GoalPriority
    val statuses: List<GoalStatus>
    val defaultStatus: GoalStatus

    fun getPriorityById(priorityId: String): GoalPriority {
        return priorities.first { it.id == priorityId }
    }

    fun getStatusById(statusId: String): GoalStatus {
        return statuses.first { it.id == statusId }
    }
}