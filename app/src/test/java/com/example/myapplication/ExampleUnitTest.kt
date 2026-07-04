package com.example.myapplication

import com.example.myapplication.data.MockData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun testMockDataItemsLoaded() {
        val items = MockData.items
        assertEquals(6, items.size)
    }

    @Test
    fun testGetItemByIdSuccess() {
        val item = MockData.getItemById("1")
        assertNotNull(item)
        assertEquals("Modern Chair", item?.title)
    }

    @Test
    fun testGetItemByIdNotFound() {
        val item = MockData.getItemById("invalid_id")
        assertNull(item)
    }
}
