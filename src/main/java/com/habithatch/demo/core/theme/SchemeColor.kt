package com.habithatch.demo.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * A color scheme that provides a light and dark color.
 */
@Immutable
data class SchemeColor(
    private val lightColor: Color,
    private val darkColor: Color,
) {
    val color: Color
        @Composable
        get() = if (isSystemInDarkTheme()) darkColor else lightColor
}
