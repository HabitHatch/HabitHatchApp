@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.habithatch.demo.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
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

@Suppress("ktlint:standard:function-naming", "FunctionNaming")
@Composable
fun AppTheme(
    typography: Typography,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val colorScheme = if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content,
    )
}
