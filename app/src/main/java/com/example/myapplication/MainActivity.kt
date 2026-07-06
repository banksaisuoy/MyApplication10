package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val featureAdapter = FeatureAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = featureAdapter
        }

        val mockFeatures = listOf(
            Feature(1, "Advanced Analytics", "Get deep insights into your data with our advanced analytics dashboard.", R.drawable.ic_launcher_foreground),
            Feature(2, "Cloud Sync", "Securely sync your data across all your devices in real-time.", R.drawable.ic_launcher_foreground),
            Feature(3, "Priority Support", "Get 24/7 priority support from our dedicated team of experts.", R.drawable.ic_launcher_foreground),
            Feature(4, "Custom Themes", "Personalize your experience with a variety of custom themes and colors.", R.drawable.ic_launcher_foreground),
            Feature(5, "Offline Mode", "Access your important files even when you don't have an internet connection.", R.drawable.ic_launcher_foreground),
            Feature(6, "Ad-Free Experience", "Enjoy a completely ad-free experience without interruptions.", R.drawable.ic_launcher_foreground)
        )

        featureAdapter.submitList(mockFeatures)
    }
}
