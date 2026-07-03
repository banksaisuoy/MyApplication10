package com.example.myapplication

import com.example.myapplication.data.MockRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class MockRepositoryTest {

    private val repository = MockRepository()

    @Test
    fun getDestinations_returnsNonEmptyList() {
        val destinations = repository.getDestinations()
        assert(destinations.isNotEmpty())
    }

    @Test
    fun getDestinationById_withValidId_returnsDestination() {
        val validId = "1"
        val destination = repository.getDestinationById(validId)

        assertNotNull(destination)
        assertEquals(validId, destination?.id)
        assertEquals("Santorini Sunset", destination?.title)
    }

    @Test
    fun getDestinationById_withInvalidId_returnsNull() {
        val invalidId = "999"
        val destination = repository.getDestinationById(invalidId)

        assertNull(destination)
    }
}
