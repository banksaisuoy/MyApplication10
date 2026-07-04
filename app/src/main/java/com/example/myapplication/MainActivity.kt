package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.ProductDetailScreen
import com.example.myapplication.ui.StoreListScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "store_list") {
                        composable("store_list") {
                            StoreListScreen(
                                onProductClick = { productId ->
                                    navController.navigate("product_detail/$productId")
                                }
                            )
                        }
                        composable("product_detail/{productId}") { backStackEntry ->
                            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                            ProductDetailScreen(
                                productId = productId ?: -1,
                                onBackClick = { navController.navigateUp() }
                            )
                        }
                    }
                }
            }
        }
    }
}
