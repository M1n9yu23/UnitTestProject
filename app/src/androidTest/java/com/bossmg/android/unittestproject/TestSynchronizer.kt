package com.bossmg.android.unittestproject

import androidx.test.espresso.idling.CountingIdlingResource
import com.bossmg.android.unittestproject.uitest.Synchronizer

class TestSynchronizer(
    private val synchronizer: Synchronizer,
    private val countingIdlingResource: CountingIdlingResource
): Synchronizer {
    override fun executeAfterDelay(callback: (Int) -> Unit) {
        countingIdlingResource.increment()
        synchronizer.executeAfterDelay {
            callback(it)
            countingIdlingResource.decrement()
        }
    }
}