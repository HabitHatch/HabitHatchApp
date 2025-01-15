package com.habithatch.demo.data.entities

/**
 * [Pet] represents a pet
 */
data class Pet(
    val id: Int,
    val name: String,
    val imageRes: Int,
    var mood: PetMood,
)
