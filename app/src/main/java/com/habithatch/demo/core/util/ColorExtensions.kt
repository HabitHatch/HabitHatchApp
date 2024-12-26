package com.habithatch.demo.core.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

/**
 * Darkens the **color** by the given factor.
 *
 * @param factor The factor to darken the color by.
 * @return The darkened color.
 */
fun Color.darken(factor: Float): Color = lerp(this, Color.Black, factor)

/**
 * Lightens the **color** by the given factor.
 *
 * @param factor The factor to lighten the color by.
 * @return The lightened color.
 */
fun Color.lighten(factor: Float) = lerp(this, Color.White, factor)
