package com.bossmg.android.unittestproject

import com.bossmg.android.unittestproject.uitest.Randomizer
import java.util.Random

class TestRandomizer(random: Random): Randomizer {
    override fun getTimeToWait(): Int {
        return 1
    }
}