package com.bossmg.android.unittestproject

import android.content.Context

class LoginValidator(
    private val context: Context
) {
    fun isValidLogin(email: String, password: String): Boolean {
        if(!email.contains("@")) {
            context.getString(R.string.error_invalid_email)
            return false
        }

        if(password.length < 6) {
            context.getString(R.string.error_short_password)
            return false
        }

        return true
    }
}