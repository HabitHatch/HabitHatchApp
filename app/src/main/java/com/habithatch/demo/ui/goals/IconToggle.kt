package com.habithatch.demo.ui.goals

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun IconToggle(
    modifier: Modifier = Modifier.size(36.dp),
    label: String,
    color: Color,
    painter: Painter,
    onToggle: () -> Unit,
) {
    IconButton(
        onClick = onToggle,
        modifier = modifier,
    ) {
        Icon(
            painter = painter,
            contentDescription = label,
            tint = color,
        )
    }
}
