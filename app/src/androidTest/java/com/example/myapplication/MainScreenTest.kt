package com.example.myapplication

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.example.myapplication.ui.screens.MainScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testMainScreenDisplaysItems() {
        composeTestRule.setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }

        // Verify TopAppBar Title
        composeTestRule.onNodeWithText("Discover").assertIsDisplayed()

        // Verify at least one mock data item is displayed
        composeTestRule.onNodeWithText("Breathtaking Mountain View").assertIsDisplayed()
        composeTestRule.onNodeWithText("Experience the serenity and majesty of the highest peaks.").assertIsDisplayed()
    }
}
