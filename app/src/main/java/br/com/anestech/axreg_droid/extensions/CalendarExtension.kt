package br.com.vinipaulino.mobile.financask.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by vinicius on 13/04/18.
 */
    fun Calendar.formataParaBrasileiro(): String? {
    val formatoBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formatoBrasileiro)
    return format.format(this.time)
}