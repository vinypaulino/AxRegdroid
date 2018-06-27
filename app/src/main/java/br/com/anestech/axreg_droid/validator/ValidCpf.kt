package br.com.anestech.axreg_droid.validator

import android.widget.EditText
import br.com.anestech.axcalc.AppConstants.Companion.ERROR_CPF_INVALID
import br.com.anestech.axcalc.AppConstants.Companion.ERROR_DIGITS_CPF
import br.com.caelum.stella.validation.CPFValidator
import br.com.caelum.stella.validation.InvalidStateException

/**
 * Created by vinicius on 21/06/18.
 */
public class ValidCpf (private val campo: EditText?)  {

    private val cpfFormatter = br.com.caelum.stella.format.CPFFormatter()
    private val defaultValidation = DefaultValidation(campo)

    private fun validCalculateCpf(): Boolean {
        return try {
            val cpfValidator = CPFValidator()
            cpfValidator.assertValid(campo?.text.toString())
            true
        } catch (e: InvalidStateException) {
            campo?.error = ERROR_CPF_INVALID
            false
        }
    }

    private fun validFieldCpfDigits(): Boolean {
        if (campo?.text.toString().length != 11) {
            campo?.error = ERROR_DIGITS_CPF
            return false
        }
        return true
    }

    fun isValid() : Boolean {
        if (!defaultValidation.isValid()) return false
      //  if (!validFieldCpfDigits()) return false
        if (!validCalculateCpf()) return false
        addFormat()
        return true
    }

    private fun addFormat() {
        val cpfFormatado: String = cpfFormatter.format(campo?.text.toString())
        campo?.setText(cpfFormatado)
    }

}