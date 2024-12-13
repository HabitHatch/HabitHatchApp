package com.habithatch.demo.core.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val screen: Screen,
    val icon: ImageVector,
    val enabled: Boolean = true
)
