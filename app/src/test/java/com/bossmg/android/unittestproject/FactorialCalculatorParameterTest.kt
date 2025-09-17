package com.bossmg.android.unittestproject

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import java.math.BigInteger

@RunWith(Parameterized::class)
class FactorialCalculatorParameterTest(
    private val input: Int,
    private val expected: BigInteger
) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun getData(): List<Array<out Any>> = listOf(
            arrayOf(0, BigInteger.ONE),
            arrayOf(1, BigInteger.ONE),
            arrayOf(5, BigInteger("120")),
            arrayOf(10, BigInteger("3628800")),
            arrayOf(20, BigInteger("2432902008176640000"))
        )
    }

    private val factorialCalculator = FactorialCalculator()

    @Test
    fun factorial() {
        val callback = mock<(BigInteger) -> Unit>()
        factorialCalculator.factorial(input, callback)
        verify(callback).invoke(expected)
    }
}