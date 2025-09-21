package com.bossmg.android.unittestproject.uitest

interface Transformer {
    fun transform(input: String, callback: (String) -> Unit)
}

class TransformerImpl : Transformer {
    override fun transform(input: String, callback: (String) -> Unit) {
        Thread {
            val result = input.uppercase()
            Thread.sleep(500)
            callback(result)
        }.start()
    }
}