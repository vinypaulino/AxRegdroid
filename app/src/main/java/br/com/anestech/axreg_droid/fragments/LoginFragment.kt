package br.com.anestech.axreg_droid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.LoginActivity
import br.com.anestech.axreg_droid.activity.MainActivity
import br.com.anestech.axreg_droid.extensions.toast
import br.com.anestech.axreg_droid.retrofit.response.CallbackResponse
import br.com.anestech.axreg_droid.retrofit.webclient.LoginWebClient
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.support.v4.startActivity

class LoginFragment : BaseFragment() {
    var loginActivity: LoginActivity = LoginActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginActivity = activity as LoginActivity

        txt_forgout_my_pass.setOnClickListener {
            loginActivity.openForgotPassword()
        }

        txt_create_account.setOnClickListener {
            loginActivity.toast("Criar Conta ! ")
        }
        btn_login.setOnClickListener {
          login()
        }
    }

    fun login() {

        val email = edt_login_email.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")
        val password = edt_login_password.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")


        LoginWebClient().login(email, password, object : CallbackResponse<User> {
            override fun failure(throwable: Throwable) {
                Log.e("OnFailure", "login nao realizado")
            }

            override fun success(response: User) {
                Log.e("success", "Login criado com sucesso")
                startActivity<MainActivity>()
            }


        })

        }
}







