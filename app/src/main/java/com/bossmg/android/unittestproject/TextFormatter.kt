package com.bossmg.android.unittestproject

import android.content.Context

class TextFormatter(
    private val factorialCalculator: FactorialCalculator,
    private val context: Context
) {
    fun getFactorialResult(n: Int, callback: (String) -> Unit) {
        try {
            factorialCalculator.factorial(n) { result ->
                callback(
                    context.getString(
                        R.string.the_factorial_of_is,
                        n,
                        result.toString()
                    )
                )
            }
        } catch (e: FactorialCalculator.NumberException) {
            callback(context.getString(R.string.error_invalid_number))
        }
    }
}