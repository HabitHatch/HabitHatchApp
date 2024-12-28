@file:Suppress("MagicNumber")

package com.habithatch.demo.core.theme

import androidx.compose.ui.graphics.Color
import com.habithatch.demo.core.util.darken
import com.habithatch.demo.core.util.lighten

val successScheme =
    SchemeColor(
        lightColor = Color.Green.darken(0.4f),
        darkColor = Color.Green.darken(0.6f),
    )

val onSuccessScheme =
    SchemeColor(
        lightColor = Color.White,
        darkColor = Color.White.copy(alpha = 0.9f),
    )

val successContainerScheme =
    SchemeColor(
        lightColor = Color.Green.lighten(0.4f),
        darkColor = Color.Green.darken(0.4f),
    )

val onSuccessContainerScheme =
    SchemeColor(
        lightColor = Color.Green.darken(0.6f),
        darkColor = Color.Green.lighten(0.6f),
    )
