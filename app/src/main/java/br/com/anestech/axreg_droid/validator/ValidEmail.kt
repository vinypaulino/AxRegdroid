package br.com.anestech.axreg_droid.validator

import android.widget.EditText
import java.util.regex.Pattern

class ValidEmail(fildEmail: EditText) {
    private val fieldEmail = fildEmail
    private val defaultValidation = DefaultValidation(fildEmail)

    fun isValid(): Boolean {
        if (!defaultValidation.isValid()) return false
        if (!isEmailValid(fieldEmail.text.toString())) {
            fieldEmail.error = "Email inválido"
            return false
        }
        return true
    }

    fun isEmailValid(email: String): Boolean {
        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\" +
                        ".([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches()
    }

    fun isValidConfirmEmail(fieldOldEmail: EditText): Boolean {
        if (!isValid()) return false
        if (!fieldEmail.text.toString().equals(fieldOldEmail.text.toString())   ) {
            fieldEmail.error = "Verifique o email digitado"
            return false
        }
        return true
    }
}
