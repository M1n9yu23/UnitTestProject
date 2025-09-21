package com.bossmg.android.unittestproject.tdd

//class PasswordValidator {
//    fun validate(password: String): Boolean {
//        if (password.length < 8) return false
//        if (!password.any { it.isUpperCase() }) return false
//        if (!password.any { it.isDigit() }) return false
//        return true
//    }
//}
// 이렇게 하면 규칙이 늘어나면서 if 문이 계속 추가됨.
// SRP 위반이 된다.

interface ValidationRule {
    fun validate(password: String): Boolean
}

class MinLengthRule(private val minLength: Int) : ValidationRule {
    override fun validate(password: String): Boolean = password.length >= minLength
}

class UppercaseRule : ValidationRule {
    override fun validate(password: String) = password.any { it.isUpperCase() }
}

class DigitRule : ValidationRule {
    override fun validate(password: String) = password.any { it.isDigit() }
}

class PasswordValidator(
    private val rules: List<ValidationRule> = listOf(
        MinLengthRule(8),
        UppercaseRule(),
        DigitRule()
    )
) {
    fun validate(password: String): Boolean {
        return rules.all { it.validate(password) }
    }
}