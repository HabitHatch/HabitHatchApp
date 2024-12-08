package com.habithatch.demo.types

import com.habithatch.demo.R

class Pet(val name: String, val imageRes: Int){

}

val AllPets = listOf(
    Pet(name = "Cat", imageRes = R.drawable.pet_cat),
    Pet(name = "Fox", imageRes = R.drawable.pet_fox),
    Pet(name = "Rabbit", imageRes = R.drawable.pet_rabbit),
    Pet(name = "Ice Bear", imageRes = R.drawable.pet_ice_bear)
)