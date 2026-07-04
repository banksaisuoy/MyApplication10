package com.example.myapplication.data

import com.example.myapplication.model.Product

object MockData {
    val products = listOf(
        Product(
            id = 1,
            name = "Elegant Watch",
            description = "A sleek, modern watch with a leather band and minimalistic face.",
            price = 199.99,
            imageUrl = "https://picsum.photos/seed/watch/400/400"
        ),
        Product(
            id = 2,
            name = "Wireless Headphones",
            description = "Noise-cancelling over-ear headphones with 40-hour battery life.",
            price = 299.50,
            imageUrl = "https://picsum.photos/seed/headphones/400/400"
        ),
        Product(
            id = 3,
            name = "Mechanical Keyboard",
            description = "RGB mechanical keyboard with tactile switches for satisfying typing.",
            price = 149.00,
            imageUrl = "https://picsum.photos/seed/keyboard/400/400"
        ),
        Product(
            id = 4,
            name = "Smart Coffee Maker",
            description = "App-controlled coffee maker that brews your perfect cup every morning.",
            price = 89.95,
            imageUrl = "https://picsum.photos/seed/coffee/400/400"
        )
    )
}
