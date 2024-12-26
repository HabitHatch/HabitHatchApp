package com.habithatch.demo.core.theme

import androidx.compose.material3.Typography
import com.habithatch.demo.core.config.HabitHatchConfig
import com.habithatch.demo.core.util.withFontFamily
import javax.inject.Inject

class TypographyFactory
    @Inject
    constructor(
        private val config: HabitHatchConfig,
    ) {
        fun create() =
            Typography().withFontFamily(
                displayFontFamily = config.displayFontFamily,
                bodyFontFamily = config.bodyFontFamily,
            )
    }
