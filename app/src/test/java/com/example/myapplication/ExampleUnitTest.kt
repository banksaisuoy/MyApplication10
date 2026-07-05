package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun mockDataGeneration_isCorrect() {
        val items = MockData.getItems()
        assertEquals(20, items.size)

        val firstItem = items.first()
        assertEquals(0, firstItem.id)
        assertEquals("Item 0", firstItem.title)
        assertTrue(firstItem.imageUrl.contains("0"))
    }
}
