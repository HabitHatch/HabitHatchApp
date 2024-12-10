package com.habithatch.demo.config

import com.habithatch.demo.R
import com.habithatch.demo.entities.Pet

object AppConfiguration {
    val pets = listOf(
        Pet(id = 1, name = "Cat", imageRes = R.mipmap.pet_cat),
        Pet(id = 2, name = "Fox", imageRes = R.mipmap.pet_fox),
        Pet(id = 3, name = "Rabbit", imageRes = R.mipmap.pet_rabbit),
        Pet(id = 4, name = "Ice Bear", imageRes = R.mipmap.pet_ice_bear)
    )
}