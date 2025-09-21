package com.bossmg.android.unittestproject

import android.app.Application
import com.bossmg.android.unittestproject.uitest.Transformer
import com.bossmg.android.unittestproject.uitest.TransformerImpl

open class MyApplication : Application() {
    lateinit var transformer: Transformer
    override fun onCreate() {
        super.onCreate()
        transformer = createTransformer()
    }

    open fun createTransformer(): Transformer = TransformerImpl()
}