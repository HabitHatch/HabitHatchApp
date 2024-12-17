package com.habithatch.demo.data.entities

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class GoalPriority(
    val label: String,
    val importance: Int,
    val iconResourceId: Int,
    val getColor: @Composable () -> Color,
) : Comparable<GoalPriority> {
    override fun compareTo(other: GoalPriority): Int {
        return importance.compareTo(other.importance)
    }
}

