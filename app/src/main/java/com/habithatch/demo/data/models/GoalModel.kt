package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import java.time.Instant
import java.util.UUID

@Immutable
data class GoalModel(
    val id: Int = 0,
    val userId: UUID? = null,
    val title: String,
    val status: Status,
    val priority: Priority,
    val createdAt: Instant?,
) {
    constructor(
        status: Status,
        priority: Priority,
    ) : this(
        id = 0,
        userId = null,
        title = "",
        status = status,
        priority = priority,
        createdAt = null,
    )

    @Immutable
    data class Priority(
        val label: String,
        val importance: Int,
        val iconResourceId: Int,
        val getColor: @Composable () -> Color,
    ) {
        @Suppress("MagicNumber")
        fun hasHighImportance(): Boolean = importance >= 20

        override fun equals(other: Any?): Boolean = other is Priority && other.label == label

        override fun hashCode(): Int = label.hashCode()
    }

    @Immutable
    data class Status(
        val label: String,
        val stepNumber: Int,
        val isDone: Boolean = false,
    ) {
        override fun equals(other: Any?): Boolean = other is Status && other.label == label

        override fun hashCode(): Int = label.hashCode()
    }

    fun isDone(): Boolean = this.status.isDone
}
