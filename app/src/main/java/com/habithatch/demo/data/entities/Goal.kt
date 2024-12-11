package com.habithatch.demo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val isDone: Boolean = false,
    val priority: GoalPriority = GoalPriority.NORMAL
) {
    constructor(
        title: String,
        isDone: Boolean = false,
        goalPriority: GoalPriority = GoalPriority.NORMAL
    ) : this(0, title, isDone, goalPriority)
}