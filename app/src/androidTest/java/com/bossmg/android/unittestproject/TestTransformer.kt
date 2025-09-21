package com.bossmg.android.unittestproject

import androidx.test.espresso.idling.CountingIdlingResource
import com.bossmg.android.unittestproject.uitest.Transformer

class TestTransformer(
    private val transformer: Transformer,
    private val countingIdlingResource: CountingIdlingResource
) : Transformer {
    override fun transform(input: String, callback: (String) -> Unit) {
        countingIdlingResource.increment()
        transformer.transform(input) {
            callback(it)
            countingIdlingResource.decrement()
        }
    }
}