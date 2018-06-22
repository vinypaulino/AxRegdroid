package br.com.anestech.axreg_droid.formatter

import android.widget.EditText

class FormatterPhoneWhithDDD {
    fun addFormat(fieldPhone : EditText) {
        val padraoEsperado = "([0-9]{2})([0-9]{4,5})([0-9]{4})".toRegex()
        val formatoEsperado = "($1) $2-$3"
        val telefoneFormatado = fieldPhone.text.toString().replace(padraoEsperado, formatoEsperado)
        fieldPhone.setText(telefoneFormatado)
    }

    fun remove(phoneWithDD: String) : String{
        return phoneWithDD
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "")
                .replace("-","")
    }
}