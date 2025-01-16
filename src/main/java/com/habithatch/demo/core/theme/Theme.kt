@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
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

private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE), // Purple
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBB86FC),
    onPrimaryContainer = Color.Black,
    secondary = Color(0xff505050), // grey
    onSecondary = Color(0xff8f9098),
    secondaryContainer = Color(0xFF018786),
    onSecondaryContainer = Color.White,
    error = Color(0xFFB00020),
    onError = Color.White,
    background = Color(0xFFFFFFFF), // white
    onBackground = Color.Black,
    surface = Color.White,
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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val colorScheme = lightColorScheme(
        inverseSurface = Color.Green
    )

    MaterialTheme(
        colorScheme = LightColorPalette,
        typography = typography,
        content = content,
    )
}
