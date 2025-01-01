package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable

/**
 * [Pet] represents a pet
 */
@Immutable
data class Pet(
    val name: String,
    val imageRes: Int,
)
