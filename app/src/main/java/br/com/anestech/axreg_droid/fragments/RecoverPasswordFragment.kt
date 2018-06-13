package br.com.anestech.axreg_droid.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.LoginActivity
import br.com.anestech.axreg_droid.retrofit.response.CallbackResponse
import br.com.anestech.axreg_droid.retrofit.webclient.LoginWebClient
import kotlinx.android.synthetic.main.fragment_recover_password.*
import org.jetbrains.anko.support.v4.startActivity


class RecoverPasswordFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_recover_password, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_send_email.setOnClickListener {
            passwordReset()
        }

        btn_close.setOnClickListener {
           startActivity<LoginActivity>()
        }
    }

    private fun passwordReset() {
        val email = edt_recovery_email.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")

        LoginWebClient().passwordReset(email, object : CallbackResponse<String> {
            override fun success(response: String) {

                SentEmailDialog(activity?.window!!.decorView as ViewGroup, activity!!)
                      .configuraDialog()

            }

            override fun failure(throwable: Throwable) {
                Log.e("failure chamado", "Falha na comunicação com o servidor")
            }

            override fun responseFailure() {
                Log.e("responseFailure chamado", "Email não encontrado")
            }

        })
    }

}
