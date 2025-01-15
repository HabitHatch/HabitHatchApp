package com.habithatch.demo.ui.habits

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import com.habithatch.demo.core.util.getAlphaFactor
import com.habithatch.demo.data.models.HabitModel
import com.habithatch.demo.ui.habits.item.HabitStyle

/**
 * The provider of the style of a habit.
 */
object HabitStyleProvider {
    @Composable
    fun getHabitStyle(habit: HabitModel): HabitStyle =
        HabitStyle(
            borderColor = MaterialTheme.colorScheme.outline,
            containerColor = getContainerColor(habit),
            textDecoration = if (habit.isDone()) TextDecoration.LineThrough else TextDecoration.None,
            iconColor = habit.priority.getColor(),
            cardShape = MaterialTheme.shapes.large,
        )

    @Composable
    private fun getContainerColor(habit: HabitModel): Color =
        if (habit.isDone()) {
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.05f * habit.priority.getAlphaFactor())
        } else {
            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f * habit.priority.getAlphaFactor())
        }
}
