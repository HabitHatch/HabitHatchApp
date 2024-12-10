package com.habithatch.demo.repositories

import com.habithatch.demo.daos.PetDao
import com.habithatch.demo.entities.Pet

class PetRepository(private val petDao: PetDao) {
    suspend fun getAll(): List<Pet> {
        return petDao.getAllPets()
    }

    suspend fun insertAll(pets: List<Pet>) {
        if (!petDao.getAllPets().isEmpty()) {
            throw IllegalStateException("Pets already exist in the database.")
        }
        petDao.insertPets(pets)
    }
}
