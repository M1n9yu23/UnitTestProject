package com.bossmg.android.unittestproject

import java.math.BigInteger
import kotlin.jvm.Throws

class FactorialCalculator {
    @Throws(NumberException::class)
    fun factorial(n: Int, callback: (BigInteger) -> Unit) {
        if(n < 0 ){
            throw NumberException
        }

        var result = BigInteger.ONE
        for(i in 1..n) {
            result = result.multiply(i.toBigInteger())
        }
        callback(result)
    }

    object NumberException : Throwable() {
        private fun readResolve(): Any = NumberException
    }
}