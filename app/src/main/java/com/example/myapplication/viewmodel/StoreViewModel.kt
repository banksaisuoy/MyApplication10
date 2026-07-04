package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.MockData
import com.example.myapplication.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StoreViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        _products.value = MockData.products
    }

    fun getProductById(id: Int): Product? {
        return _products.value.find { it.id == id }
    }
}
