package br.com.anestech.axreg_droid.fragments

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.LoginActivity
import kotlinx.android.synthetic.main.dialog_sent_email.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity
import kotlin.coroutines.experimental.coroutineContext
import kotlin.system.exitProcess

/**
 * Created by Vinícius Paulino on 12/06/18.
 */
class SentEmailDialog(private val viewGroup: ViewGroup,
                      private val context: Context) {

    private val viewCriada = criaLayout()

    fun configuraDialog() {
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

        viewCriada.btn_resend_email.setOnClickListener {
            AlertDialog.Builder(context)
                    .setTitle(R.string.title_success)
                    .setMessage(R.string.msg_email_success)
                    .setPositiveButton(R.string.ok) { dialog, _ ->
                        dialog.dismiss()
                        context.startActivity<LoginActivity>()
                    }
                    .create()
                    .show()
        }

        viewCriada.btn_close_dialog.setOnClickListener {
            context.startActivity<LoginActivity>()
        }
        return viewCriada
    }
}