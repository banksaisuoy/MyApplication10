package com.example.myapplication.data

data class PremiumItem(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val price: String
)

object MockData {
    val premiumItems = listOf(
        PremiumItem(
            id = 1,
            title = "Quantum Analytics",
            description = "Real-time predictive modeling with advanced neural networks.",
            imageUrl = "https://images.unsplash.com/photo-1551288049-bebda4e38f71?auto=format&fit=crop&q=80&w=800",
            price = "$99/mo"
        ),
        PremiumItem(
            id = 2,
            title = "Cloud Security Pro",
            description = "Military-grade encryption and automated threat detection.",
            imageUrl = "https://images.unsplash.com/photo-1563986768609-322da13575f3?auto=format&fit=crop&q=80&w=800",
            price = "$149/mo"
        ),
        PremiumItem(
            id = 3,
            title = "Global CDN Hub",
            description = "Lightning-fast content delivery across 200+ edge locations.",
            imageUrl = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?auto=format&fit=crop&q=80&w=800",
            price = "$199/mo"
        ),
        PremiumItem(
            id = 4,
            title = "AI Automation Suite",
            description = "Streamline your workflow with intelligent bots and triggers.",
            imageUrl = "https://images.unsplash.com/photo-1518770660439-4636190af475?auto=format&fit=crop&q=80&w=800",
            price = "$299/mo"
        )
    )
}
