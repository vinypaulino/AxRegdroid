package br.com.anestech.axreg_droid.activity

import android.os.Bundle
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.extensions.addFragment
import br.com.anestech.axreg_droid.extensions.replaceFragment
import br.com.anestech.axreg_droid.fragments.login.LoginFragment
import br.com.anestech.axreg_droid.fragments.login.RecoverPasswordFragment
import br.com.anestech.axreg_droid.utils.Prefs
import org.jetbrains.anko.startActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userEmail = Prefs.getString("email")

        if (userEmail.isNullOrEmpty()){
            addFragment(R.id.frame_login, LoginFragment())
        } else
            startActivity<MainActivity>()

    }

    fun openForgotPassword(){
        replaceFragment(R.id.frame_activity_login, RecoverPasswordFragment())
    }




}
