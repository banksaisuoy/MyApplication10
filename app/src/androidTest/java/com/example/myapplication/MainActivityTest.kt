package com.example.myapplication

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.Test
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greeting_isDisplayed() {
        // Start the app
        composeTestRule.setContent {
            MyApplicationTheme {
                Greeting("Android")
            }
        }

        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }
}
