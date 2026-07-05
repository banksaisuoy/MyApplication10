package com.example.myapplication.data

object MockRepository {
    private val products = listOf(
        Product(
            id = "1",
            name = "Premium Wireless Headphones",
            description = "Experience immersive sound with our top-of-the-line wireless headphones featuring active noise cancellation.",
            price = 299.99,
            imageUrl = "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=1000&auto=format&fit=crop"
        ),
        Product(
            id = "2",
            name = "Smart Fitness Watch",
            description = "Track your workouts, heart rate, and sleep with this sleek and durable smart fitness watch.",
            price = 149.50,
            imageUrl = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?q=80&w=1000&auto=format&fit=crop"
        ),
        Product(
            id = "3",
            name = "Ergonomic Office Chair",
            description = "Work in comfort all day with our fully adjustable ergonomic office chair with lumbar support.",
            price = 199.00,
            imageUrl = "https://images.unsplash.com/photo-1592078615290-033ee584e267?q=80&w=1000&auto=format&fit=crop"
        ),
        Product(
            id = "4",
            name = "Mechanical Gaming Keyboard",
            description = "Elevate your gaming with tactile switches, customizable RGB backlighting, and a premium aluminum frame.",
            price = 129.99,
            imageUrl = "https://images.unsplash.com/photo-1595225476474-87563907a212?q=80&w=1000&auto=format&fit=crop"
        ),
        Product(
            id = "5",
            name = "4K Action Camera",
            description = "Capture your adventures in stunning 4K resolution. Waterproof, durable, and packed with features.",
            price = 249.00,
            imageUrl = "https://images.unsplash.com/photo-1526170375885-4d8ecf77b99f?q=80&w=1000&auto=format&fit=crop"
        )
    )

    fun getProducts(): List<Product> = products

    fun getProduct(id: String): Product? = products.find { it.id == id }
}
