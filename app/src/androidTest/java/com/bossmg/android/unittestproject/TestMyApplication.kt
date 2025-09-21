package com.bossmg.android.unittestproject

import androidx.test.espresso.idling.CountingIdlingResource
import com.bossmg.android.unittestproject.uitest.Transformer

class TestMyApplication : MyApplication() {
    val countingIdlingResource = CountingIdlingResource("StringTransform resource")

    override fun createTransformer(): Transformer =
        TestTransformer(super.createTransformer(), countingIdlingResource)

}