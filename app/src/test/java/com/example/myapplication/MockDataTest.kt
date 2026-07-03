package com.example.myapplication

import com.example.myapplication.model.MockData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class MockDataTest {
    @Test
    fun testGetItems_returnsNonEmptyList() {
        val items = MockData.getItems()
        assertTrue(items.isNotEmpty())
        assertEquals(5, items.size)
    }

    @Test
    fun testGetItemById_returnsCorrectItem() {
        val item = MockData.getItemById("1")
        assertNotNull(item)
        assertEquals("Majestic Mountains", item?.title)
    }

    @Test
    fun testGetItemById_returnsNullForInvalidId() {
        val item = MockData.getItemById("invalid_id")
        assertTrue(item == null)
    }
}
