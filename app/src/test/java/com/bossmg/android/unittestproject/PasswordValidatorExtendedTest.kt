package com.bossmg.android.unittestproject

import com.bossmg.android.unittestproject.tdd.MinLengthRule
import com.bossmg.android.unittestproject.tdd.PasswordValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorExtendedTest {
    private val validator = PasswordValidator()

    @Test
    fun passwordMissingUppercase() {
        assertFalse(validator.validate("password123"))
    }

    @Test
    fun passwordMissingDigit() {
        assertFalse(validator.validate("PasswordTest"))
    }

    @Test
    fun validStrongPassword() {
        assertTrue(validator.validate("HelloWorld123"))
    }

    @Test
    fun customValidatorWithDifferentMinLength() {
        val customValidator = PasswordValidator(listOf(MinLengthRule(12)))
        assertFalse(customValidator.validate("Short1A"))
        assertTrue(customValidator.validate("VeryStrongPass1"))
    }
}