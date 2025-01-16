@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val ColorScheme.success: Color
    @Composable
    get() = successScheme.color

val ColorScheme.onSuccess: Color
    @Composable
    get() = onSuccessScheme.color

val ColorScheme.successContainer: Color
    @Composable
    get() = successContainerScheme.color

val ColorScheme.onSuccessContainer: Color
    @Composable
    get() = onSuccessContainerScheme.color

/**
 * The [AppTheme] composable, which sets the color scheme and typography for the app.
 * The Colors are dynamically set with Material You, depending one users wallpaper.
 */
@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AppTheme(
    typography: Typography,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content,
    )
}
