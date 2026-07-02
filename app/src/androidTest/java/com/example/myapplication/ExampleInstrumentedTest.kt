package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testClickCounter() {
        // Initial state
        onView(withId(R.id.tvWelcomeMessage)).check(matches(withText("Welcome to My Application!")))

        // Click once
        onView(withId(R.id.btnClickMe)).perform(click())
        onView(withId(R.id.tvWelcomeMessage)).check(matches(withText("Clicked 1 times!")))

        // Click twice
        onView(withId(R.id.btnClickMe)).perform(click())
        onView(withId(R.id.tvWelcomeMessage)).check(matches(withText("Clicked 2 times!")))
    }
}
