package com.habithatch.demo.daos

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.Pet
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class PetDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var petDao: PetDao

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        petDao = database.petDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun `getAllPets() should return all pets in the database`() {
        runBlocking {
            // Arrange
            val pets = listOf(
                Pet(1, "Cat", 123),
                Pet(2, "Dog", 456)
            )

            // Act
            petDao.insertPets(pets)
            val retrievedPets = petDao.getAllPets()

            // Assert
            assertThat(retrievedPets).hasSize(2)
            assertThat(retrievedPets).containsExactlyElementsIn(pets)
        }
    }
}
