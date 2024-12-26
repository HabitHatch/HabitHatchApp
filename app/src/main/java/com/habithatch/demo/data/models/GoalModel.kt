package com.habithatch.demo.data.models

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import com.habithatch.demo.ui.goals.item.GoalStyle
import java.util.Date

data class GoalModel(
    val id: Int = 0,
    val title: String,
    val status: Status,
    val priority: Priority,
    val createdAt: Date? = null,
) {
    constructor(
        status: Status,
        priority: Priority,
    ) : this(
        id = 0,
        title = "",
        status = status,
        priority = priority,
    )

    data class Priority(
        val label: String,
        val importance: Int,
        val iconResourceId: Int,
        val getColor: @Composable () -> Color,
    ) {
        fun getAlphaFactor(): Float =
            if (importance >= 20) {
                4f
            } else if (importance >= 10) {
                2f
            } else {
                1f
            }

        override fun equals(other: Any?): Boolean = other is Priority && other.label == label

        override fun hashCode(): Int = label.hashCode()
    }

    data class Status(
        val label: String,
        val stepNumber: Int,
        val isDone: Boolean = false,
    ) {
        override fun equals(other: Any?): Boolean = other is Status && other.label == label

        override fun hashCode(): Int = label.hashCode()
    }

    @Composable
    fun getGoalStyle(): GoalStyle =

        GoalStyle(
            borderColor = MaterialTheme.colorScheme.outline,
            containerColor =
                if (isDone()) {
                    MaterialTheme.colorScheme.secondary.copy(alpha = 0.05f * priority.getAlphaFactor())
                } else {
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.1f * priority.getAlphaFactor())
                },
            textDecoration = if (isDone()) TextDecoration.LineThrough else TextDecoration.None,
            iconColor = priority.getColor(),
            cardShape = MaterialTheme.shapes.large,
        )

    fun isDone(): Boolean = this.status.isDone
}
