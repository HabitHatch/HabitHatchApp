package com.habithatch.demo.ui.goals

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import com.habithatch.demo.core.util.getAlphaFactor
import com.habithatch.demo.data.models.GoalModel
import com.habithatch.demo.ui.goals.item.GoalStyle

object GoalStyleProvider {
    @Composable
    fun getContainerColor(goal: GoalModel): Color =
        if (goal.isDone()) {
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.05f * goal.priority.getAlphaFactor())
        } else {
            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f * goal.priority.getAlphaFactor())
        }

    @Composable
    fun getGoalStyle(goal: GoalModel): GoalStyle =
        GoalStyle(
            borderColor = MaterialTheme.colorScheme.outline,
            containerColor = getContainerColor(goal),
            textDecoration = if (goal.isDone()) TextDecoration.LineThrough else TextDecoration.None,
            iconColor = goal.priority.getColor(),
            cardShape = MaterialTheme.shapes.large,
        )
}
