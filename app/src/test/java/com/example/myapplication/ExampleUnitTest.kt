package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun dataStore_items_are_populated() {
        assertTrue(DataStore.items.isNotEmpty())
    }

    @Test
    fun dataStore_getItem_returns_correct_item() {
        val firstItem = DataStore.items.first()
        val retrievedItem = DataStore.getItem(firstItem.id)
        assertNotNull(retrievedItem)
        assertEquals(firstItem, retrievedItem)
    }

    @Test
    fun dataStore_getItem_returns_null_for_invalid_id() {
        val retrievedItem = DataStore.getItem(-1)
        assertNull(retrievedItem)
    }
}
