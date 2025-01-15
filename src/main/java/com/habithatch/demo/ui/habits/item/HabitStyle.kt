package com.habithatch.demo.ui.habits.item

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

/**
 * The style of a habit.
 *
 * @param borderColor The color of the border.
 * @param containerColor The color of the container.
 * @param textDecoration The text decoration.
 * @param iconColor The color of the icon.
 * @param cardShape The shape of the card.
 */
data class HabitStyle(
    val borderColor: Color,
    val containerColor: Color,
    val textDecoration: TextDecoration = TextDecoration.None,
    val iconColor: Color,
    val cardShape: CornerBasedShape,
) {
    val textColor: Color
        @Composable get() = MaterialTheme.colorScheme.contentColorFor(containerColor)

    val cardColors: CardColors
        @Composable get() =
            CardDefaults.cardColors(
                containerColor = containerColor,
            )
    val textStyle: TextStyle
        @Composable get() =
            MaterialTheme.typography.titleMedium.copy(
                textDecoration = textDecoration,
                color = textColor,
            )
}
