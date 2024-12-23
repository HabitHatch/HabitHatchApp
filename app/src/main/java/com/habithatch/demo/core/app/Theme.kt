package com.habithatch.demo.core.app

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val CustomTypography =
    Typography(
        displayLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
            ),
        displayMedium =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
            ),
        displaySmall =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
            ),
        headlineLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
            ),
        bodyMedium =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            ),
        bodySmall =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            ),
        labelMedium =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
        titleSmall =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
            ),
    )

val CustomColorScheme =
    ColorScheme(
        primary = Color(0xFF6200EA),
        onPrimary = Color.White,
        primaryContainer = Color(0xFFBB86FC),
        onPrimaryContainer = Color.White,
        inversePrimary = Color(0xFF3700B3),
        secondary = Color(0xFF03DAC6),
        onSecondary = Color.Black,
        secondaryContainer = Color(0xFF018786),
        onSecondaryContainer = Color.White,
        tertiary = Color(0xFF03A9F4),
        onTertiary = Color.White,
        tertiaryContainer = Color(0xFFB3E5FC),
        onTertiaryContainer = Color.Black,
        background = Color.White,
        onBackground = Color.Black,
        surface = Color.White,
        onSurface = Color.Black,
        surfaceVariant = Color(0xFFE0E0E0),
        onSurfaceVariant = Color.Black,
        surfaceTint = Color(0xFF6200EA),
        inverseSurface = Color.Black,
        inverseOnSurface = Color.White,
        error = Color(0xFFB00020),
        onError = Color.White,
        errorContainer = Color(0xFFFFDAD4),
        onErrorContainer = Color.Black,
        outline = Color(0xFFBDBDBD),
        outlineVariant = Color(0xFF757575),
        scrim = Color(0x66000000),
        surfaceBright = Color.White,
        surfaceDim = Color(0xFFE0E0E0),
        surfaceContainer = Color.White,
        surfaceContainerHigh = Color(0xFFEEEEEE),
        surfaceContainerHighest = Color(0xFFE0E0E0),
        surfaceContainerLow = Color.White,
        surfaceContainerLowest = Color.White,
    )

@Suppress("ktlint:standard:function-naming")
@Composable
fun HabitHatchAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomColorScheme,
        typography = CustomTypography,
        content = content,
    )
}
