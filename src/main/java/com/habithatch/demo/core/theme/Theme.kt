@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.success: Color
    @Composable
    get() = successScheme.color

private val appColorScheme =
    lightColorScheme(
        primary = Color(0xFF6200EE),
        onPrimary = Color.White,
        primaryContainer = Color(0xFFBB86FC),
        onPrimaryContainer = Color.Black,
        secondary = Color(0xff505050),
        onSecondary = Color(0xff8f9098),
        secondaryContainer = Color(0xFF018786),
        onSecondaryContainer = Color.White,
        error = Color(0xFFB00020),
        onError = Color.White,
        background = Color.White,
        onBackground = Color.Black,
        surface = Color.White,
        inverseSurface = Color.Green,
        onSurface = Color.Black,
    )

/**
 * The [AppTheme] composable, which sets the color scheme and typography for the app.
 * The Colors are dynamically set with Material You, depending one users wallpaper.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AppTheme(
    typography: Typography,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = appColorScheme,
        typography = typography,
        content = content,
    )
}
