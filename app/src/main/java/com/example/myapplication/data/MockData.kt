package com.example.myapplication.data

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String
)

object MockData {
    fun getItems(): List<Item> {
        return listOf(
            Item(
                id = 1,
                title = "Breathtaking Mountain View",
                description = "Experience the serenity and majesty of the highest peaks.",
                imageUrl = "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"
            ),
            Item(
                id = 2,
                title = "Ocean Waves",
                description = "Feel the calming rhythm of the ocean waves crashing against the shore.",
                imageUrl = "https://images.unsplash.com/photo-1505118380757-91f5f5632de0?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"
            ),
            Item(
                id = 3,
                title = "Enchanted Forest",
                description = "Wander through the mystical and ancient woods.",
                imageUrl = "https://images.unsplash.com/photo-1448375240586-882707db888b?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"
            ),
            Item(
                id = 4,
                title = "Desert Dunes",
                description = "Discover the vast, shifting sands of the great desert.",
                imageUrl = "https://images.unsplash.com/photo-1509316785289-025f5b846b35?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"
            ),
            Item(
                id = 5,
                title = "City Skyline",
                description = "Behold the vibrant and bustling life of the city at night.",
                imageUrl = "https://images.unsplash.com/photo-1477959858617-67f85cf4f1df?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"
            )
        )
    }
}
