package com.example.myapplication

import com.example.myapplication.data.MockData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MockDataTest {

    @Test
    fun testGetItemsReturnsNonEmptyList() {
        val items = MockData.getItems()
        assertTrue(items.isNotEmpty())
    }

    @Test
    fun testGetItemsContainsValidData() {
        val items = MockData.getItems()
        assertEquals(5, items.size)

        items.forEach { item ->
            assertTrue(item.title.isNotBlank())
            assertTrue(item.description.isNotBlank())
            assertTrue(item.imageUrl.isNotBlank())
            assertTrue(item.imageUrl.startsWith("http"))
        }
    }
}
