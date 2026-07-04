package com.example.myapplication

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class StoreUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun storeList_displaysProductsAndNavigatesToDetails() {
        // Verify the title of the list screen
        composeTestRule.onNodeWithText("Discover Products").assertExists()

        // Verify a product is displayed
        composeTestRule.onNodeWithText("Elegant Watch").assertExists()

        // Click on the product
        composeTestRule.onNodeWithText("Elegant Watch").performClick()

        // Verify we navigated to the detail screen (product description should be visible)
        composeTestRule.onNodeWithText("A sleek, modern watch with a leather band and minimalistic face.").assertExists()
    }
}
