package com.habithatch.demo.config

import com.habithatch.demo.R
import com.habithatch.demo.entities.Pet

object AppConfiguration {
    val pets = listOf(
        Pet(name = "Cat", imageRes = R.drawable.pet_cat),
        Pet(name = "Fox", imageRes = R.drawable.pet_fox),
        Pet(name = "Rabbit", imageRes = R.drawable.pet_rabbit),
        Pet(name = "Ice Bear", imageRes = R.drawable.pet_ice_bear)
    )
}