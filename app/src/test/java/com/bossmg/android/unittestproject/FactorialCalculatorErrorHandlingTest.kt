package com.bossmg.android.unittestproject

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import java.math.BigInteger

@RunWith(MockitoJUnitRunner::class)
class FactorialCalculatorErrorHandlingTest {
    @InjectMocks
    lateinit var factorialCalculator: FactorialCalculator

    @Test(expected = FactorialCalculator.NumberException::class)
    fun factorial() {
        val input = -5
        val callback = mock<(BigInteger) -> Unit>()
        factorialCalculator.factorial(input, callback)
    }

}