package com.habithatch.demo.features.home

import com.habithatch.demo.data.entities.Pet

/**
 * Represents the main state information for the home screen.
 *
 * @param pet The pet to display.
 * @param isUserLoggedIn Whether the user is logged in.
 * @param allGoalsDone Whether all goals are done.
 * @param onFabClicked The callback for when the Floating Action Button is clicked.
 */
data class CoreHomeState(
    val pet: Pet?,
    val isUserLoggedIn: Boolean = false,
    val allGoalsDone: Boolean = false,
    val onFabClicked: () -> Unit = {},
)
