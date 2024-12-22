package com.habithatch.demo.data.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class GoalModel(
    val id: Int? = null,
    val title: String,
    val status: Status,
    val priority: Priority
) {

    fun updateStatus(newStatus: Status): GoalModel {
        return copy(status = newStatus)
    }

    data class Priority(
        val label: String,
        val importance: Int,
        val iconResourceId: Int,
        val getColor: @Composable () -> Color,
    ){
        override fun equals(other: Any?): Boolean {
            return other is Priority && other.label == label
        }

        override fun hashCode(): Int = label.hashCode()
    }

    data class Status(
        val label: String,
        val stepNumber: Int,
        val isDone: Boolean = false
    ){

        override fun equals(other: Any?): Boolean {
            return other is Status && other.label == label
        }

        override fun hashCode(): Int = label.hashCode()
    }

    fun isDone(): Boolean {
        return this.status.isDone
    }
}
