package com.habithatch.demo.data.repositories

import com.habithatch.demo.data.entities.Pet

class PetRepository(private val pets: List<Pet>) {
    fun getAll(): List<Pet> {
        return pets
    }
}
