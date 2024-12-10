package com.habithatch.demo.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.habithatch.demo.entities.Pet

@Dao
interface PetDao {
    @Query("SELECT * FROM pet")
    suspend fun getAllPets(): List<Pet>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPets(pets: List<Pet>)
}
