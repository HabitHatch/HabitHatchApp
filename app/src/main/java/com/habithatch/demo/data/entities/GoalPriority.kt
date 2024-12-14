package com.habithatch.demo.data.entities

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.habithatch.demo.R

enum class GoalPriority(
    val label: String,
    val iconResourceId: Int,
    val getColor: @Composable () -> Color,
) {
    NORMAL(
            label = "Normal",
            iconResourceId = R.drawable.vuesax_bookmark,
            getColor = @Composable { MaterialTheme.colorScheme.secondary }
    ),
    HIGH(
            label = "High",
            iconResourceId = R.drawable.vuesax_crown,
            getColor = @Composable { MaterialTheme.colorScheme.primary }
    );

    fun getHigherPriorityOrLowest(): GoalPriority {
        val currentIndex = entries.indexOf(this)
        val nextIndex = (currentIndex + 1) % entries.size
        return entries[nextIndex]
    }
}