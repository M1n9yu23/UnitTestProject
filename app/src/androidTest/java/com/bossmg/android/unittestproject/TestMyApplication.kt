package com.bossmg.android.unittestproject

import androidx.test.espresso.idling.CountingIdlingResource
import com.bossmg.android.unittestproject.uitest.Randomizer
import com.bossmg.android.unittestproject.uitest.Synchronizer
import java.util.Random

class TestMyApplication : MyApplication() {
    val countingIdlingResource = CountingIdlingResource("Timer resource")

    override fun createSynchronizer(): Synchronizer {
        return TestSynchronizer(super.createSynchronizer(), countingIdlingResource)
    }

    override fun createRandomizer(): Randomizer {
        return TestRandomizer(Random())
    }
}