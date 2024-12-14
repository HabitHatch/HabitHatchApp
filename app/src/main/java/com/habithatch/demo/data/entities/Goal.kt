package com.habithatch.demo.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Goal(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val doneState: GoalDoneState =  GoalDoneState.UNDONE,
    val priority: GoalPriority = GoalPriority.NORMAL
) {
    init {
        require(title.isNotBlank()) { "Title must not be empty or blank." }
    }
}