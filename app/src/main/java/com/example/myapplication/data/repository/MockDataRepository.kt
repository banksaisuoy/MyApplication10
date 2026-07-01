package com.example.myapplication.data.repository

import com.example.myapplication.data.model.DashboardItem
import com.example.myapplication.data.model.User
import kotlinx.coroutines.delay

class MockDataRepository {

    suspend fun login(email: String, password: String): Result<User> {
        delay(1000) // Simulate network delay
        return if (email == "test@example.com" && password == "password") {
            Result.success(User("1", email, "Test User"))
        } else {
            Result.failure(Exception("Invalid email or password"))
        }
    }

    suspend fun getDashboardItems(): List<DashboardItem> {
        delay(500) // Simulate network delay
        return listOf(
            DashboardItem("1", "Premium Feature A", "Exclusive access to feature A"),
            DashboardItem("2", "Premium Feature B", "Exclusive access to feature B"),
            DashboardItem("3", "Premium Feature C", "Exclusive access to feature C"),
            DashboardItem("4", "Premium Feature D", "Exclusive access to feature D"),
            DashboardItem("5", "Premium Feature E", "Exclusive access to feature E")
        )
    }

    suspend fun getDashboardStats(): Map<String, String> {
        delay(500)
        return mapOf(
            "Users" to "10,234",
            "Revenue" to "$45,678",
            "Active" to "89%"
        )
    }
}
