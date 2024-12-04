package com.habithatch.demo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Typography


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
