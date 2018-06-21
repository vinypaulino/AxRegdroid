package br.com.anestech.axreg_droid.validator

import android.widget.EditText
import br.com.anestech.axcalc.AppConstants.Companion.ERROR_FIELD_REQUIRED
import br.com.anestech.axreg_droid.R

/**
 * Created by vinicius on 21/06/18.
 */
public class DefaultValidation(campo: EditText?) {

    private val campo = campo

    private fun validFieldRequired(): Boolean {
        if (this.campo?.text.toString().isEmpty()) {
            this.campo?.error = ERROR_FIELD_REQUIRED
            return false
        }
        return true
    }

    fun isValid(): Boolean {
        if (!validFieldRequired()) return false

        return true
    }
}