package com.example.myapplication

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun listScreen_displaysItemsAndNavigates() {
        composeTestRule.setContent {
            AppNavigation()
        }

        // Verify that the list screen displays the first item
        composeTestRule.onNodeWithText("Item 0").assertExists()

        // Click on the first item
        composeTestRule.onNodeWithText("Item 0").performClick()

        // Verify that we navigated to the detail screen (it should have a description)
        composeTestRule.onNodeWithText("This is a detailed description for item 0. It has a lot of interesting properties that we can look at on the detail screen.").assertExists()
    }
}
