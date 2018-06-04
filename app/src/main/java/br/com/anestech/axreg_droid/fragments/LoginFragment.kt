package br.com.anestech.axreg_droid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.LoginActivity
import br.com.anestech.axreg_droid.activity.MainActivity
import br.com.anestech.axreg_droid.extensions.toast
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.support.v4.startActivity

class LoginFragment : BaseFragment() {
    var loginActivity : LoginActivity = LoginActivity()

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

        txt_create_account.setOnClickListener{
            loginActivity.toast("Criar Conta ! ")
        }
        btn_login.setOnClickListener {
           startActivity<MainActivity>()
        }
    }
}


