package com.example.myapplication

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.example.myapplication.data.MockRepository
import com.example.myapplication.ui.DashboardScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test

class DashboardUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun dashboardDisplaysDestinations() {
        val repository = MockRepository()
        val destinations = repository.getDestinations()

        composeTestRule.setContent {
            MyApplicationTheme {
                DashboardScreen(
                    destinations = destinations,
                    onDestinationClick = {}
                )
            }
        }

        // Verify the title is displayed
        composeTestRule.onNodeWithText("Discover Places").assertIsDisplayed()

        // Verify the first destination is displayed
        val firstDestination = destinations.first()
        composeTestRule.onNodeWithText(firstDestination.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(firstDestination.location).assertIsDisplayed()
    }
}
