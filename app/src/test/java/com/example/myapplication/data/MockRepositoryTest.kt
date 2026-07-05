package com.example.myapplication.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class MockRepositoryTest {

    @Test
    fun getProducts_returnsNonEmptyList() {
        val products = MockRepository.getProducts()
        assertEquals(true, products.isNotEmpty())
        assertEquals(5, products.size)
    }

    @Test
    fun getProduct_withValidId_returnsProduct() {
        val product = MockRepository.getProduct("1")
        assertNotNull(product)
        assertEquals("1", product?.id)
        assertEquals("Premium Wireless Headphones", product?.name)
    }

    @Test
    fun getProduct_withInvalidId_returnsNull() {
        val product = MockRepository.getProduct("999")
        assertNull(product)
    }
}
