package br.com.anestech.axreg_droid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.LoginActivity
import br.com.anestech.axreg_droid.activity.MainActivity
import br.com.anestech.axreg_droid.extensions.toast
import br.com.anestech.axreg_droid.retrofit.webclient.LoginWebClient
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.startActivity

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
          login{ Toast.makeText(context, "Login Realizado", Toast.LENGTH_LONG).show()  }
        }
    }
    fun login(created: (createdUser: User) -> Unit) {

        val email = edt_login_email.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")
        var password = edt_login_password.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")

        var localUser = User()
        localUser.email = email
        localUser.password = password

        LoginWebClient().login(localUser, {

             created(it)
            activity?.startActivity<MainActivity>()
        }, {
            Toast.makeText(context, "Erro ao realizar o login", Toast.LENGTH_LONG).show()
        })

    }

    }







