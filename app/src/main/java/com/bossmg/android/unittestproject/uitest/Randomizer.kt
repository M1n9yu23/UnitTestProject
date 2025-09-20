package com.bossmg.android.unittestproject.uitest

import java.util.Random

class RandomizerImpl(
    private val random: Random
) : Randomizer {
    override fun getTimeToWait(): Int = random.nextInt(5) + 1
}

interface Randomizer {
    fun getTimeToWait(): Int
}