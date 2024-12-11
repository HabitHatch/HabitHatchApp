package com.habithatch.demo.repositories

import com.habithatch.demo.entities.Pet

class PetRepository(private val pets: List<Pet>) {
    fun getAll(): List<Pet> {
        return pets
    }
}
