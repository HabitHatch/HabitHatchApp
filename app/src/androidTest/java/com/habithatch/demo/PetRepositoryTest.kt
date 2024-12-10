package com.habithatch.demo

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.Pet
import com.habithatch.demo.repositories.PetRepository
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class PetRepositoryTest {

    private lateinit var database: AppDatabase
    private lateinit var petRepository: PetRepository

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        val petDao = database.petDao()
        petRepository = PetRepository(petDao)
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertStaticPets_whenEmptyDatabase_shouldInsertPets() {
        runBlocking {
            // Arrange
            val pets = listOf(Pet(1, "Cat", 123), Pet(2, "Dog", 456))

            // Act
            petRepository.insertStaticPets(pets)
            val retrievedPets = petRepository.getAllPets()

            // Assert
            assertThat(retrievedPets).containsExactlyElementsIn(pets)
        }
    }

    @Test
    fun insertStaticPets_whenNotEmpty_shouldThrowException() {
        runBlocking {
            // Arrange
            val pets = listOf(Pet(1, "Cat", 123), Pet(2, "Dog", 456))
            petRepository.insertStaticPets(pets)

            val exception = kotlin.runCatching {
                petRepository.insertStaticPets(pets)
            }.exceptionOrNull()

            // Assert
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }
}
