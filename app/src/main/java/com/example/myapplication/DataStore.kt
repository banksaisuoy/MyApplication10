package com.example.myapplication

data class Item(val id: Int, val title: String, val description: String, val imageUrl: String)

object DataStore {
    val items = listOf(
        Item(1, "Mountain Retreat", "A beautiful cabin in the snowy mountains.", "https://images.unsplash.com/photo-1510798831971-661eb04b3739?w=400"),
        Item(2, "Beach Paradise", "Relax on the sunny shores with crystal clear water.", "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=400"),
        Item(3, "City Lights", "Experience the vibrant nightlife of the metropolis.", "https://images.unsplash.com/photo-1449824913935-59a10b8d2000?w=400"),
        Item(4, "Forest Trail", "Hike through the lush green forests.", "https://images.unsplash.com/photo-1448375240586-882707db888b?w=400"),
        Item(5, "Desert Oasis", "Discover a hidden gem in the vast desert.", "https://images.unsplash.com/photo-1473580044384-7ba9967e16a0?w=400")
    )

    fun getItem(id: Int): Item? = items.find { it.id == id }
}
