package com.habithatch.demo.repositories

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.db.AppDatabase
import com.habithatch.demo.entities.Pet
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

// TODO: Make Unit Test
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
    fun `insertAll(), should insert Pets, when pets table is empty`() {
        runBlocking {
            // Arrange
            val pets = listOf(Pet(1, "Cat", 123), Pet(2, "Dog", 456))

            // Act
            petRepository.insertAll(pets)
            val retrievedPets = petRepository.getAll()

            // Assert
            assertThat(retrievedPets).containsExactlyElementsIn(pets)
        }
    }

    @Test
    fun `insertAll(), should throw IllegalStateException, when pets table is not empty`() {
        runBlocking {
            // Arrange
            val pets = listOf(Pet(1, "Cat", 123), Pet(2, "Dog", 456))
            petRepository.insertAll(pets)

            // Act
            val exception = runCatching {
                petRepository.insertAll(pets)
            }.exceptionOrNull()

            // Assert
            assertThat(exception).isInstanceOf(IllegalStateException::class.java)
        }
    }
}
