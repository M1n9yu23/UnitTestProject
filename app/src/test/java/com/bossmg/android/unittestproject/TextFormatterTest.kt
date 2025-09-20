package com.bossmg.android.unittestproject

import android.content.Context
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import java.math.BigInteger

@RunWith(MockitoJUnitRunner::class)
class TextFormatterTest {
    @InjectMocks
    lateinit var textFormatter: TextFormatter

    @Mock
    lateinit var factorialCalculator: FactorialCalculator

    @Mock
    lateinit var context: Context

    @Test
    fun getFactorialResult_success() {
        val n = 5
        val factorialResult = BigInteger("120")
        val expected = "expected"

        whenever(factorialCalculator.factorial(eq(n), any())).thenAnswer {
            (it.arguments[1] as (BigInteger) -> Unit).invoke(factorialResult)
        }

        whenever(
            context.getString(
                R.string.the_factorial_of_is,
                n,
                factorialResult.toString()
            )
        ).thenReturn(expected)

        val callback = mock<(String) -> Unit>()

        textFormatter.getFactorialResult(n, callback)

        verify(callback).invoke(expected)
    }

    @Test
    fun getFactorialResult_error() {
        val n = -5
        val expected = "expected"

        whenever(factorialCalculator.factorial(eq(n), any()))
            .thenThrow(FactorialCalculator.NumberException)

        whenever(context.getString(R.string.error_invalid_number)).thenReturn(expected)

        val callback = mock<(String) -> Unit>()

        textFormatter.getFactorialResult(n, callback)

        verify(callback).invoke(expected)
    }
}