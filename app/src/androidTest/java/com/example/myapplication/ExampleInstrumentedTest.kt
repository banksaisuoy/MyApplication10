package com.example.myapplication

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appNavigation_fromListToDetailAndBack() {
        composeTestRule.setContent {
            AppNavigation()
        }

        // Verify we are on the list screen by checking for the top bar title
        composeTestRule.onNodeWithText("Discover Places").assertExists()

        // Find the first item and click it
        val firstItem = DataStore.items.first()
        composeTestRule.onNodeWithText(firstItem.title).assertExists().performClick()

        // Verify we navigated to the detail screen
        composeTestRule.onNodeWithText(firstItem.title).assertExists()
        composeTestRule.onNodeWithText(firstItem.description).assertExists()

        // Navigate back
        composeTestRule.onNodeWithContentDescription("Back").assertExists().performClick()

        // Verify we are back on the list screen
        composeTestRule.onNodeWithText("Discover Places").assertExists()
    }
}
