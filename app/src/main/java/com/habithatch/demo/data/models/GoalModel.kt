package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.util.Date

data class GoalModel(
    val id: Int? = null,
    val title: String,
    val status: Status,
    val priority: Priority,
    val createdAt: Date,
) {
    fun updateStatus(newStatus: Status): GoalModel = copy(status = newStatus)

    data class Priority(
        val label: String,
        val importance: Int,
        val iconResourceId: Int,
        val getColor: @Composable () -> Color,
    ) {
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

    fun isDone(): Boolean = this.status.isDone
}
