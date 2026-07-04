package com.example.myapplication

import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.data.MockData
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 * Here we test that the app navigation works correctly in Compose.
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun appNavigatesToDetailScreenAndBack() {
        // Start the app with AppNavigation
        composeTestRule.setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }

        // Verify that the HomeScreen is loaded by checking for the top bar title
        composeTestRule.onNodeWithText("Explore Destinations").assertExists()

        // Get the first destination name from MockData to ensure consistency
        val firstDestination = MockData.destinations.first()

        // Click on the first destination card
        composeTestRule.onNodeWithText(firstDestination.name).performClick()

        // Verify that we navigated to DetailScreen by checking for "Book Now"
        composeTestRule.onNodeWithText("Book Now").assertExists()

        // Verify that the correct destination name is shown on the Detail Screen
        composeTestRule.onNodeWithText(firstDestination.name).assertExists()

        // Click the back button (its content description is "Back")
        composeTestRule.onNodeWithContentDescription("Back").performClick()
    }
}
