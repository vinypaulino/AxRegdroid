package br.com.anestech.axreg_droid.fragments

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anestech.axreg_droid.R
import kotlin.coroutines.experimental.coroutineContext

/**
 * Created by vinicius on 12/06/18.
 */
class SentEmailDialog(private val viewGroup: ViewGroup,
                      private val context: Context) {

    private val viewCriada = criaLayout()

    fun configuraDialog(){
        configuraFormulario()
    }

    private fun configuraFormulario() {
        AlertDialog.Builder(context)
                .setView(viewCriada)
                .show()
    }

    fun criaLayout(): View {
        val viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.dialog_sent_email,
                        viewGroup,
                        false)
        return viewCriada
    }

}

