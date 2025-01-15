package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

/**
 * [HabitEntity] is a Room entity that represents a habit.
 */
@Immutable
@Entity(tableName = "habit")
data class HabitEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val userId: UUID,
    val statusLabel: String,
    val priorityLabel: String,
    val createdAt: Instant,
)
