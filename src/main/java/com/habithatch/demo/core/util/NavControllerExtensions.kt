package com.habithatch.demo.core.util

import androidx.navigation.NavController
import com.habithatch.demo.core.navigation.Screen

fun NavController.navigateTo(screen: Screen) {
    navigate(screen.route)
}
