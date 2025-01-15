package com.habithatch.demo.features.home

import com.habithatch.demo.data.entities.Pet

/**
 * Represents the main state information for the home screen.
 *
 * @param pet The pet to display.
 * @param onFabClicked The callback for when the Floating Action Button is clicked.
 */
data class CoreHomeState(
    val pet: Pet,
    val onFabClicked: () -> Unit = {},
)
