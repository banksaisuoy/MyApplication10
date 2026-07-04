package com.example.myapplication.data

data class Destination(
    val id: String,
    val name: String,
    val location: String,
    val description: String,
    val imageUrl: String,
    val rating: Float,
    val price: Double
)

object MockData {
    val destinations = listOf(
        Destination(
            id = "1",
            name = "Bali Paradiso",
            location = "Bali, Indonesia",
            description = "Experience the stunning beaches, vibrant culture, and lush landscapes of Bali. Perfect for a relaxing getaway or an adventurous retreat.",
            imageUrl = "https://picsum.photos/seed/bali/800/600",
            rating = 4.8f,
            price = 1200.00
        ),
        Destination(
            id = "2",
            name = "Swiss Alps Retreat",
            location = "Zermatt, Switzerland",
            description = "Nestled in the breathtaking Swiss Alps, enjoy world-class skiing, majestic mountain views, and cozy alpine lodges.",
            imageUrl = "https://picsum.photos/seed/alps/800/600",
            rating = 4.9f,
            price = 2500.00
        ),
        Destination(
            id = "3",
            name = "Kyoto Sakura",
            location = "Kyoto, Japan",
            description = "Immerse yourself in Japan's rich history, beautiful temples, traditional tea houses, and the enchanting cherry blossom season.",
            imageUrl = "https://picsum.photos/seed/kyoto/800/600",
            rating = 4.7f,
            price = 1800.00
        ),
        Destination(
            id = "4",
            name = "Santorini Sunsets",
            location = "Santorini, Greece",
            description = "Famous for its stunning sunsets, white-washed buildings, and crystal-clear Aegean waters. A truly romantic destination.",
            imageUrl = "https://picsum.photos/seed/greece/800/600",
            rating = 4.6f,
            price = 1500.00
        ),
        Destination(
            id = "5",
            name = "Safari Adventure",
            location = "Serengeti, Tanzania",
            description = "Witness the Great Migration and encounter majestic wildlife in their natural habitat on an unforgettable African safari.",
            imageUrl = "https://picsum.photos/seed/safari/800/600",
            rating = 4.9f,
            price = 3200.00
        )
    )

    fun getDestinationById(id: String): Destination? {
        return destinations.find { it.id == id }
    }
}
