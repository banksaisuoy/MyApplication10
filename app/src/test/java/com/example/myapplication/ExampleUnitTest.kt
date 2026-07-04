package com.example.myapplication

import com.example.myapplication.data.MockData
import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun `test MockData retrieves destination correctly`() {
        // Arrange
        val validId = "1"

        // Act
        val destination = MockData.getDestinationById(validId)

        // Assert
        assertNotNull("Destination should not be null", destination)
        assertEquals("Bali Paradiso", destination?.name)
    }

    @Test
    fun `test MockData returns null for invalid id`() {
        // Arrange
        val invalidId = "999"

        // Act
        val destination = MockData.getDestinationById(invalidId)

        // Assert
        assertNull("Destination should be null for an invalid id", destination)
    }

    @Test
    fun `test MockData contains required fields`() {
        // Arrange
        val validId = "2"

        // Act
        val destination = MockData.getDestinationById(validId)

        // Assert
        assertNotNull(destination)
        assertTrue(destination!!.name.isNotEmpty())
        assertTrue(destination.description.isNotEmpty())
        assertTrue(destination.rating > 0.0)
        assertTrue(destination.price > 0.0)
    }
}
