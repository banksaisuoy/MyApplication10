package com.example.myapplication

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun productListRendersSuccessfully() {
        composeTestRule.onNodeWithText("Our Products").assertExists()
        composeTestRule.onNodeWithTag("ProductList").assertExists()
        // Check for the first product
        composeTestRule.onNodeWithText("Premium Wireless Headphones").assertExists()
    }

    @Test
    fun clickProduct_navigatesToDetailScreen() {
        // Find the first product item and click it
        composeTestRule.onNodeWithTag("ProductItem_1").performClick()

        // Verify we are on the DetailScreen
        composeTestRule.onNodeWithTag("DetailScreen").assertExists()

        // Verify product details are shown
        composeTestRule.onNodeWithText("Premium Wireless Headphones").assertExists()
        composeTestRule.onNodeWithText("Add to Cart").assertExists()
    }

    @Test
    fun clickBackButtonOnDetailScreen_navigatesBackToList() {
        // Find the first product item and click it
        composeTestRule.onNodeWithTag("ProductItem_1").performClick()

        // Verify we are on the DetailScreen
        composeTestRule.onNodeWithTag("DetailScreen").assertExists()

        // Click the back button
        composeTestRule.onNodeWithTag("BackButton").performClick()

        // Verify we are back on the MainScreen list
        composeTestRule.onNodeWithTag("ProductList").assertExists()
    }
}
