package com.habithatch.demo.repositories

import com.google.common.truth.Truth.assertThat
import com.habithatch.demo.data.entities.Pet
import com.habithatch.demo.data.repositories.PetRepository
import org.junit.Test

class PetRepositoryTest {
    @Test
    fun `getAll() should return pets passed in to constructor`() {
        // Arrange
        val pets = listOf(Pet("Cat", 123), Pet("Dog", 456))
        val petRepository = PetRepository(pets)
        // Act
        val result = petRepository.getAll()
        // Assert
        assertThat(result).isEqualTo(pets)
    }
}
