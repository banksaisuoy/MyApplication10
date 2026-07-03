package com.example.myapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.data.MockRepository

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val repository = remember { MockRepository() }

    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen(
                destinations = repository.getDestinations(),
                onDestinationClick = { destinationId ->
                    navController.navigate("detail/$destinationId")
                }
            )
        }
        composable(
            route = "detail/{destinationId}",
            arguments = listOf(navArgument("destinationId") { type = NavType.StringType })
        ) { backStackEntry ->
            val destinationId = backStackEntry.arguments?.getString("destinationId")
            val destination = repository.getDestinationById(destinationId ?: "")

            if (destination != null) {
                DetailScreen(
                    destination = destination,
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
