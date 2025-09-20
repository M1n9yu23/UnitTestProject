package com.bossmg.android.unittestproject

import android.app.Application
import com.bossmg.android.unittestproject.uitest.Randomizer
import com.bossmg.android.unittestproject.uitest.RandomizerImpl
import com.bossmg.android.unittestproject.uitest.Synchronizer
import com.bossmg.android.unittestproject.uitest.SynchronizerImpl
import java.util.Random
import java.util.Timer

open class MyApplication : Application() {
    lateinit var synchronizer: Synchronizer

    override fun onCreate() {
        super.onCreate()
        synchronizer = createSynchronizer()
    }


    open fun createRandomizer(): Randomizer = RandomizerImpl(Random())

    open fun createSynchronizer(): Synchronizer = SynchronizerImpl(createRandomizer(), Timer())

}