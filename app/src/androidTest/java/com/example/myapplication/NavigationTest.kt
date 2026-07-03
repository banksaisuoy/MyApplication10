package com.example.myapplication

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.ui.screens.DetailScreen
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNavigationToDetailScreen() {
        composeTestRule.setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }

        // Verify we are on the Home screen
        composeTestRule.onNodeWithText("Discover").assertExists()
        composeTestRule.onNodeWithText("Majestic Mountains").assertExists()

        // Click on the first item
        composeTestRule.onNodeWithText("Majestic Mountains").performClick()

        // Verify we navigated to the Detail screen
        composeTestRule.onNodeWithText("Majestic Mountains").assertExists()
        composeTestRule.onNodeWithText("Explore the breathtaking peaks and valleys.").assertExists()
    }
}
