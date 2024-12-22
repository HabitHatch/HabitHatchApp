package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class GoalModel(
    val id: Int = 0,
    val title: String,
    val status: Status,
    val priority: Priority
) {
    init {
        require(title.isNotBlank()) { "Goal title must not be blank" }
    }

    fun updateStatus(newStatus: Status): GoalModel {
        return copy(status = newStatus)
    }

    data class Priority(
        val id: String,
        val label: String,
        val importance: Int,
        val iconResourceId: Int,
        val getColor: @Composable () -> Color,
    ) : Comparable<Priority> {
        override fun compareTo(other: Priority): Int {
            return importance.compareTo(other.importance)
        }

        override fun equals(other: Any?): Boolean {
            return other is Priority && other.id == id
        }

        override fun hashCode(): Int {
            return id.hashCode()
        }
    }

    data class Status(
        val id: String,
        val label: String,
        val stepNumber: Int,
        val isDone: Boolean
    ) : Comparable<Status> {
        override fun compareTo(other: Status): Int {
            return stepNumber.compareTo(other.stepNumber)
        }

        override fun equals(other: Any?): Boolean {
            return other is Status && other.id == id
        }

        override fun hashCode(): Int {
            return id.hashCode()
        }
    }

    fun isDone(): Boolean {
        return status.isDone
    }
}
