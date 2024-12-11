package com.habithatch.demo.util

import org.junit.Test
import com.google.common.truth.Truth.assertThat


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestUUIDUtilities {
    @Test
    fun `should return true for valid UUID`() {
        // Arrange
        val validUUID = "d4d027a5-9574-4558-86a0-dae10477f741"
        // Act
        val result = isValidUuid(validUUID)
        // Assert
        assertThat(result).isTrue()
    }

    @Test
    fun `should return false for invalid UUID`() {
        // Arrange
        val invalidUUID = "invalid-uuid"
        // Act
        val result = isValidUuid(invalidUUID)
        // Assert
        assertThat(result).isFalse()
    }
}