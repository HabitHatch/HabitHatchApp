package com.habithatch.demo.core.util

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily

fun Typography.withFontFamily(
    displayFontFamily: FontFamily,
    bodyFontFamily: FontFamily,
): Typography =
    Typography(
        displayLarge = displayLarge.copy(fontFamily = displayFontFamily),
        displayMedium = displayMedium.copy(fontFamily = displayFontFamily),
        displaySmall = displaySmall.copy(fontFamily = displayFontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = displayFontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = displayFontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = displayFontFamily),
        titleLarge = titleLarge.copy(fontFamily = displayFontFamily),
        titleMedium = titleMedium.copy(fontFamily = displayFontFamily),
        titleSmall = titleSmall.copy(fontFamily = displayFontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = bodyFontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = bodyFontFamily),
        bodySmall = bodySmall.copy(fontFamily = bodyFontFamily),
        labelLarge = labelLarge.copy(fontFamily = bodyFontFamily),
        labelMedium = labelMedium.copy(fontFamily = bodyFontFamily),
        labelSmall = labelSmall.copy(fontFamily = bodyFontFamily),
    )
