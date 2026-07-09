package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder

data class Item(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String
)

val mockItems = listOf(
    Item("1", "Beautiful Mountain", "A stunning view of a snow-capped mountain range at sunrise.", "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?w=800&q=80"),
    Item("2", "Serene Lake", "A calm lake reflecting the surrounding forest and sky.", "https://images.unsplash.com/photo-1439853949127-fa647821eba0?w=800&q=80"),
    Item("3", "Lush Forest", "A dense green forest with sunlight filtering through the canopy.", "https://images.unsplash.com/photo-1448375240586-882707db888b?w=800&q=80"),
    Item("4", "Desert Dunes", "Golden sand dunes stretching under a clear blue sky.", "https://images.unsplash.com/photo-1509316785289-025f5b846b35?w=800&q=80"),
    Item("5", "City Skyline", "A modern city skyline illuminated at night.", "https://images.unsplash.com/photo-1477959858617-67f85cf4f1df?w=800&q=80")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("details/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            val item = mockItems.find { it.id == itemId }
            if (item != null) {
                DetailsScreen(item, navController)
            } else {
                Text("Item not found")
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DashboardScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(mockItems) { item ->
            val interactionSource = remember { MutableInteractionSource() }
            val isPressed by interactionSource.collectIsPressedAsState()
            val scale by animateFloatAsState(
                targetValue = if (isPressed) 0.95f else 1f,
                animationSpec = tween(durationMillis = 150),
                label = "scale"
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(scale)
                    .shadow(elevation = 8.dp, shape = RoundedCornerShape(24.dp))
                    .clickable(
                        interactionSource = interactionSource,
                        indication = androidx.compose.material.ripple.rememberRipple(),
                        onClick = { navController.navigate("details/${item.id}") }
                    ),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GlideImage(
                        model = item.imageUrl,
                        contentDescription = "Image for ${item.title}",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        failure = placeholder(R.mipmap.ic_launcher),
                        loading = placeholder(R.mipmap.ic_launcher_round)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = item.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.description,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 2
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(item: Item, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box {
            GlideImage(
                model = item.imageUrl,
                contentDescription = "Image for ${item.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)),
                contentScale = ContentScale.Crop,
                failure = placeholder(R.mipmap.ic_launcher),
                loading = placeholder(R.mipmap.ic_launcher_round)
            )
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(top = 32.dp, start = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black.copy(alpha = 0.5f))
            ) {
                Text("Back", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
        )
        Text(
            text = item.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
        )
    }
}
