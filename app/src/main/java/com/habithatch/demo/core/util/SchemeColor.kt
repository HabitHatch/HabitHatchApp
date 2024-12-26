package com.habithatch.demo.core.util

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class SchemeColor(
    private val lightColor: Color,
    private val darkColor: Color,
) {
    val color: Color
        @Composable
        get() = if (isSystemInDarkTheme()) darkColor else lightColor
}
