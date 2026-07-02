package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ItemModel(
    val id: String,
    val title: String,
    val description: String,
    val dateStr: String
) {
    companion object {
        fun generateMockData(count: Int): List<ItemModel> {
            val list = mutableListOf<ItemModel>()
            val dateFormat = SimpleDateFormat("MMM dd, yyyy - hh:mm a", Locale.getDefault())
            val currentTime = System.currentTimeMillis()

            val sampleTitles = listOf(
                "Stunning Landscape", "Modern Architecture", "Minimalist Design",
                "Vibrant Colors", "Abstract Art", "Urban Jungle"
            )
            val sampleDescriptions = listOf(
                "An incredible display of natural beauty and harmony.",
                "A perfect blend of form and function in modern times.",
                "Simplicity at its best, focusing on the essentials.",
                "A captivating explosion of hues that draws the eye.",
                "Thought-provoking shapes and patterns to inspire you.",
                "The organized chaos of city life captured perfectly."
            )

            for (i in 0 until count) {
                // Generate a time somewhat in the past to look realistic
                val randomPastTime = currentTime - (Math.random() * 1000000000).toLong()
                list.add(
                    ItemModel(
                        id = "ID-$i-${System.currentTimeMillis()}",
                        title = sampleTitles[i % sampleTitles.size] + " $i",
                        description = sampleDescriptions[i % sampleDescriptions.size],
                        dateStr = dateFormat.format(Date(randomPastTime))
                    )
                )
            }
            return list
        }
    }
}
