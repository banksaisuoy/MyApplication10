package com.example.myapplication.data

data class Destination(
    val id: String,
    val title: String,
    val location: String,
    val description: String,
    val imageUrl: String,
    val rating: Double,
    val price: Double
)

class MockRepository {
    fun getDestinations(): List<Destination> {
        return listOf(
            Destination(
                id = "1",
                title = "Santorini Sunset",
                location = "Santorini, Greece",
                description = "Experience the breathtaking sunsets over the caldera. White-washed houses cling to cliffs above an underwater caldera, offering stunning views and world-class cuisine.",
                imageUrl = "https://images.unsplash.com/photo-1613395877344-13d4a8e0d49e?auto=format&fit=crop&q=80&w=1000",
                rating = 4.9,
                price = 1200.0
            ),
            Destination(
                id = "2",
                title = "Kyoto Gardens",
                location = "Kyoto, Japan",
                description = "Wander through tranquil bamboo forests and ancient temples. Kyoto offers a glimpse into traditional Japan with its stunning gardens, Geisha districts, and exquisite culinary traditions.",
                imageUrl = "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?auto=format&fit=crop&q=80&w=1000",
                rating = 4.8,
                price = 950.0
            ),
            Destination(
                id = "3",
                title = "Banff National Park",
                location = "Alberta, Canada",
                description = "Discover the rugged beauty of the Canadian Rockies. Crystal clear turquoise lakes, towering mountain peaks, and abundant wildlife make this a nature lover's paradise.",
                imageUrl = "https://images.unsplash.com/photo-1553901753-215db0446d9e?auto=format&fit=crop&q=80&w=1000",
                rating = 5.0,
                price = 850.0
            ),
            Destination(
                id = "4",
                title = "Machu Picchu",
                location = "Cusco Region, Peru",
                description = "Explore the lost city of the Incas. Set high in the Andes Mountains, this ancient citadel is a testament to the engineering genius of the Inca Empire.",
                imageUrl = "https://images.unsplash.com/photo-1587595431973-160d0d94add1?auto=format&fit=crop&q=80&w=1000",
                rating = 4.9,
                price = 1100.0
            ),
            Destination(
                id = "5",
                title = "Amalfi Coast",
                location = "Campania, Italy",
                description = "Drive along the dramatic coastline of southern Italy. Pastel-colored fishing villages terraced into sheer cliffs present one of the most picturesque coastal drives in the world.",
                imageUrl = "https://images.unsplash.com/photo-1633321088355-d0f81134ca3b?auto=format&fit=crop&q=80&w=1000",
                rating = 4.7,
                price = 1400.0
            )
        )
    }

    fun getDestinationById(id: String): Destination? {
        return getDestinations().find { it.id == id }
    }
}
