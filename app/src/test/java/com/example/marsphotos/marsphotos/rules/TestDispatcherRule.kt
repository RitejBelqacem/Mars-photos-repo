package com.example.marsphotos.marsphotos.rules

import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.rules.TestWatcher
import kotlinx.coroutines.Dispatchers
import org.junit.runner.Description
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain
class TestDispatcherRule(
    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}