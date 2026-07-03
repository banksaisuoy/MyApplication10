package com.example.myapplication.model

data class Item(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String
)

object MockData {
    fun getItems(): List<Item> {
        return listOf(
            Item("1", "Majestic Mountains", "Explore the breathtaking peaks and valleys.", "https://picsum.photos/seed/mountains/800/600"),
            Item("2", "Serene Beaches", "Relax on the sandy shores and listen to the waves.", "https://picsum.photos/seed/beaches/800/600"),
            Item("3", "Dense Forests", "Wander through the ancient, towering trees.", "https://picsum.photos/seed/forests/800/600"),
            Item("4", "Bustling Cities", "Experience the vibrant life and neon lights.", "https://picsum.photos/seed/cities/800/600"),
            Item("5", "Tranquil Lakes", "Reflect by the calm and peaceful waters.", "https://picsum.photos/seed/lakes/800/600")
        )
    }

    fun getItemById(id: String): Item? {
        return getItems().find { it.id == id }
    }
}
