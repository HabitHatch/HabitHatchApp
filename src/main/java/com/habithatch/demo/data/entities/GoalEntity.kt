package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.UUID

/**
 * [GoalEntity] is a Room entity that represents a goal.
 */
@Immutable
@Entity(tableName = "goal")
data class GoalEntity(
    @PrimaryKey val id: Long,
    val title: String,
    val userId: UUID,
    val statusLabel: String,
    val priorityLabel: String,
    val createdAt: Instant,
)
