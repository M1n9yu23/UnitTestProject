package com.bossmg.android.unittestproject

import android.content.Context
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock


private const val ERROR_EMAIL = "이메일 형식이 올바르지 않습니다."
private const val ERROR_PASSWORD = "비밀번호는 6자리 이상이어야 합니다."

@RunWith(MockitoJUnitRunner::class)
class LoginValidatorErrorHandlingTest {

    private val context = mock<Context>()

    @Test
    fun 이메일형식이잘못되면_false() {
        `when`(context.getString(R.string.error_invalid_email)).thenReturn(ERROR_EMAIL)
        val validator = LoginValidator(context)

        val result = validator.isValidLogin("invalidEmail", "123456")

        assertFalse(result)
    }

    @Test
    fun 비밀번호가짧으면_false() {
        `when`(context.getString(R.string.error_short_password)).thenReturn(ERROR_PASSWORD)
        val validator = LoginValidator(context)

        val result = validator.isValidLogin("user@example.com", "123")

        assertFalse(result)
    }
}