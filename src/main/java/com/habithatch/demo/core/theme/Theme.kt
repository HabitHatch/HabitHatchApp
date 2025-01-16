@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

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
    content: @Composable () -> Unit,
) {
    LocalContext.current
    val colorScheme = darkColorScheme()
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content,
    )
}
