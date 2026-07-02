package com.example.myapplication

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun counterLogic_incrementsCorrectly() {
        val logic = CounterLogic()
        assertEquals(0, logic.count)

        logic.increment()
        assertEquals(1, logic.count)

        logic.increment()
        assertEquals(2, logic.count)
    }
}
