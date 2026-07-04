package com.example.myapplication

import com.example.myapplication.viewmodel.StoreViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class StoreViewModelTest {

    @Test
    fun loadProducts_populatesProductsList() {
        val viewModel = StoreViewModel()
        // verify products are loaded by default in init
        val products = viewModel.products.value
        assertEquals(4, products.size)
        assertEquals("Elegant Watch", products[0].name)
    }

    @Test
    fun getProductById_returnsCorrectProduct() {
        val viewModel = StoreViewModel()
        val product = viewModel.getProductById(1)
        assertNotNull(product)
        assertEquals(1, product?.id)
        assertEquals("Elegant Watch", product?.name)
    }

    @Test
    fun getProductById_returnsNullForInvalidId() {
        val viewModel = StoreViewModel()
        val product = viewModel.getProductById(999)
        assertNull(product)
    }
}
