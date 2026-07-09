package com.example.myapplication

data class DashboardItem(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String
)

val mockItems = listOf(
    DashboardItem(
        id = "1",
        title = "Majestic Mountains",
        description = "A breathtaking view of snow-capped peaks under a clear blue sky. Perfect for a weekend getaway.",
        imageUrl = "https://images.unsplash.com/photo-1506905925275-6a49a554a9cb?q=80&w=600&auto=format&fit=crop"
    ),
    DashboardItem(
        id = "2",
        title = "Serene Forest",
        description = "Sunlight streaming through tall green trees in a quiet, peaceful forest environment.",
        imageUrl = "https://images.unsplash.com/photo-1448375240586-882707db888b?q=80&w=600&auto=format&fit=crop"
    ),
    DashboardItem(
        id = "3",
        title = "Ocean Waves",
        description = "Crashing waves on a sandy beach during a beautiful golden hour sunset.",
        imageUrl = "https://images.unsplash.com/photo-1505118380757-91f5f5632de0?q=80&w=600&auto=format&fit=crop"
    ),
    DashboardItem(
        id = "4",
        title = "Urban Cityscape",
        description = "A bustling city skyline with modern architecture and bright lights at night.",
        imageUrl = "https://images.unsplash.com/photo-1477959858617-67f85cf4f1df?q=80&w=600&auto=format&fit=crop"
    ),
    DashboardItem(
        id = "5",
        title = "Desert Dunes",
        description = "Rolling sand dunes glowing orange and red in the warm afternoon sun.",
        imageUrl = "https://images.unsplash.com/photo-1509316785289-025f5b846b35?q=80&w=600&auto=format&fit=crop"
    )
)
