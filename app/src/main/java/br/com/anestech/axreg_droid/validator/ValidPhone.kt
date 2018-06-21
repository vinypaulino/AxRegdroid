package br.com.anestech.axreg_droid.validator

import android.widget.EditText
import br.com.anestech.axcalc.AppConstants.Companion.ERROR_PHONE_DIGITS

/**
 * Created by vinicius on 21/06/18.
 */
public class ValidPhone(fieldPhone: EditText) {

    private val fieldPhone = fieldPhone
    private val defaultValidation = DefaultValidation(fieldPhone)


    private fun validNumberPhone(phoneWithDDD: String): Boolean {
        val digits = phoneWithDDD.length
        if (digits < 10 || digits > 11) {
            fieldPhone.error = ERROR_PHONE_DIGITS
            return false
        }
        return true
    }

    fun isValid(): Boolean {
        if (!defaultValidation.isValid()) return false
        if (!validNumberPhone(fieldPhone.text.toString())) return false

        addFormat()

        return true
    }

    private fun addFormat() {
         TODO("implementar esse codigo")
    }
}