package com.habithatch.demo.data.entities

import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val name: String,
    val imageRes: Int,
)
