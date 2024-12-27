package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Immutable
@Entity(tableName = "goal")
data class GoalEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val statusLabel: String,
    val priorityLabel: String,
    val createdAt: Instant,
)
