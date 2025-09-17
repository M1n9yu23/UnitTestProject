package com.bossmg.android.unittestproject

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.kotlin.mock

@RunWith(Parameterized::class)
class LoginValidatorTest(
    private val email: String,
    private val password: String,
    private val expected: Boolean
) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun data() = listOf(
            arrayOf("user@example.com", "123456", true),
            arrayOf("userexample.com", "123456", false),
            arrayOf("user@example.com", "123", false)
        )
    }

    private val context = mock<Context>()
    private val validator = LoginValidator(context)

    @Test
    fun 로그인검증() {
        val result = validator.isValidLogin(email, password)
        assertEquals(expected, result)
    }
}