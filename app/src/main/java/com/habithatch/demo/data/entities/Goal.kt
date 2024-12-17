package com.habithatch.demo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val status: GoalStatus =  GoalStatus.IN_PROGRESS,
    val priority: GoalPriority = GoalPriority.NORMAL
) {
    init {
        require(title.isNotBlank()) { "Title must not be empty or blank." }
        require(title.length <= 50) { "Title must not exceed 50 characters." }
    }
}