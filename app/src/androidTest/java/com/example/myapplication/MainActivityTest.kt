package com.example.myapplication

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testHomeScreenDisplaysItems() {
        // Verify that the title "Discover" is displayed
        composeTestRule.onNodeWithText("Discover").assertExists()

        // Verify that the first item "Premium Headphones" is displayed
        composeTestRule.onNodeWithText("Premium Headphones").assertExists()
    }

    @Test
    fun testNavigationToDetailScreenAndBack() {
        // Click on the first item
        composeTestRule.onNodeWithText("Premium Headphones").performClick()

        // Verify that the detail screen is displayed (e.g., checking for the description)
        composeTestRule.onNodeWithText("High-quality noise-canceling headphones for an immersive experience.").assertExists()

        // Click the back button
        composeTestRule.onNodeWithContentDescription("Back").performClick()

        // Verify we are back on the home screen
        composeTestRule.onNodeWithText("Discover").assertExists()
    }
}