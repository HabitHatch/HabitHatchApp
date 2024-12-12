package com.habithatch.demo.core

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


val AppTypography = Typography()
val AppColorScheme = lightColorScheme()

@Composable
fun HabitHatchAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
            colorScheme = AppColorScheme,
            typography = AppTypography,
            content = content
    )
}
