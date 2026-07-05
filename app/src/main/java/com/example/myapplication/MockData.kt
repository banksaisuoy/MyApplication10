package com.example.myapplication

data class StoreItem(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val price: Double
)

object MockData {
    val items = listOf(
        StoreItem(
            id = "1",
            title = "Premium Headphones",
            description = "High-quality noise-canceling headphones for an immersive experience.",
            imageUrl = "https://picsum.photos/seed/headphones/400/300",
            price = 299.99
        ),
        StoreItem(
            id = "2",
            title = "Smartwatch",
            description = "Track your fitness and stay connected on the go.",
            imageUrl = "https://picsum.photos/seed/smartwatch/400/300",
            price = 199.50
        ),
        StoreItem(
            id = "3",
            title = "Mechanical Keyboard",
            description = "Ergonomic mechanical keyboard with customizable RGB lighting.",
            imageUrl = "https://picsum.photos/seed/keyboard/400/300",
            price = 149.00
        ),
        StoreItem(
            id = "4",
            title = "Wireless Mouse",
            description = "Precision wireless mouse with ultra-low latency.",
            imageUrl = "https://picsum.photos/seed/mouse/400/300",
            price = 79.99
        ),
        StoreItem(
            id = "5",
            title = "4K Monitor",
            description = "Stunning 4K resolution monitor for creative professionals.",
            imageUrl = "https://picsum.photos/seed/monitor/400/300",
            price = 499.00
        )
    )

    fun getItem(id: String): StoreItem? {
        return items.find { it.id == id }
    }
}
