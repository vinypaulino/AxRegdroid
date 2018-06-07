package br.com.anestech.axreg_droid.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.extensions.addFragment
import br.com.anestech.axreg_droid.extensions.replaceFragment
import br.com.anestech.axreg_droid.fragments.LoginFragment
import br.com.anestech.axreg_droid.fragments.RecoverPasswordFragment

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        addFragment(R.id.frame_login, LoginFragment())
    }

    fun openForgotPassword(){
        replaceFragment(R.id.frame_login, RecoverPasswordFragment())
    }


}
