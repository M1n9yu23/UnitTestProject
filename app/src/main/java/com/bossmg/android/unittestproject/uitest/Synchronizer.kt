package com.bossmg.android.unittestproject.uitest

import java.util.Timer
import java.util.TimerTask

class SynchronizerImpl(
    private val randomizer: Randomizer,
    private val timer: Timer
) : Synchronizer {
    override fun executeAfterDelay(callback: (Int) -> Unit) {
        val timeToWait = randomizer.getTimeToWait()
        timer.schedule(CallbackTask(callback, timeToWait), timeToWait * 1000L)
    }

    inner class CallbackTask(
        private val callback: (Int) -> Unit,
        private val time: Int
    ) : TimerTask() {
        override fun run() {
            callback(time)
        }
    }
}

interface Synchronizer {
    fun executeAfterDelay(callback: (Int) -> Unit)
}
