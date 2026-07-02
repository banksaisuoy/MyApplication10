package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test

class ItemModelTest {

    @Test
    fun testGenerateMockData() {
        val count = 10
        val items = ItemModel.generateMockData(count)

        assertEquals("List size should match requested count", count, items.size)

        items.forEach { item ->
            assertNotNull("Item ID should not be null", item.id)
            assertTrue("Item ID should not be empty", item.id.isNotEmpty())

            assertNotNull("Item title should not be null", item.title)
            assertTrue("Item title should not be empty", item.title.isNotEmpty())

            assertNotNull("Item description should not be null", item.description)
            assertTrue("Item description should not be empty", item.description.isNotEmpty())

            assertNotNull("Item date string should not be null", item.dateStr)
            assertTrue("Item date string should not be empty", item.dateStr.isNotEmpty())
        }
    }
}
