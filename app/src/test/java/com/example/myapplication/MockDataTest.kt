package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test

class MockDataTest {
    @Test
    fun testMockDataIsNotEmpty() {
        assertFalse("Mock data items should not be empty", MockData.items.isEmpty())
    }

    @Test
    fun testGetItemReturnsCorrectItem() {
        val item = MockData.getItem("1")
        assertNotNull("Item with ID 1 should exist", item)
        assertEquals("Premium Headphones", item?.title)
    }

    @Test
    fun testGetItemReturnsNullForInvalidId() {
        val item = MockData.getItem("invalid_id")
        assertNull("Item with invalid ID should be null", item)
    }
}
