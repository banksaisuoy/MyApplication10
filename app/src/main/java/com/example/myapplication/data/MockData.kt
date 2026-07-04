package com.example.myapplication.data

data class Item(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val price: Double
)

object MockData {
    val items = listOf(
        Item(
            id = "1",
            title = "Modern Chair",
            description = "A comfortable and stylish modern chair suitable for any living room or office. Crafted with premium materials to ensure durability and aesthetic appeal.",
            imageUrl = "https://images.unsplash.com/photo-1598300042247-d088f8ab3a91?w=500&q=80",
            price = 149.99
        ),
        Item(
            id = "2",
            title = "Ceramic Vase",
            description = "Minimalist ceramic vase perfect for holding fresh flowers or as a standalone decorative piece in your home.",
            imageUrl = "https://images.unsplash.com/photo-1610701596007-11502861dcfa?w=500&q=80",
            price = 45.00
        ),
        Item(
            id = "3",
            title = "Pendant Light",
            description = "Industrial style pendant light that adds a warm glow to your dining area or kitchen island. Features a matte black finish.",
            imageUrl = "https://images.unsplash.com/photo-1513506003901-1e6a229e2d15?w=500&q=80",
            price = 89.50
        ),
        Item(
            id = "4",
            title = "Wooden Desk",
            description = "Spacious wooden desk with a natural finish. Includes two drawers for convenient storage of office supplies.",
            imageUrl = "https://images.unsplash.com/photo-1518455027359-f3f8164ba6bd?w=500&q=80",
            price = 299.00
        ),
        Item(
            id = "5",
            title = "Abstract Painting",
            description = "Original abstract painting on canvas. Vibrant colors will instantly brighten up any wall space.",
            imageUrl = "https://images.unsplash.com/photo-1541961017774-22349e4a1262?w=500&q=80",
            price = 550.00
        ),
        Item(
            id = "6",
            title = "Cozy Throw Blanket",
            description = "Extremely soft and cozy throw blanket. Made from 100% cotton, perfect for chilly evenings on the sofa.",
            imageUrl = "https://images.unsplash.com/photo-1580828369066-608b49e89d15?w=500&q=80",
            price = 35.99
        )
    )

    fun getItemById(id: String): Item? {
        return items.find { it.id == id }
    }
}
