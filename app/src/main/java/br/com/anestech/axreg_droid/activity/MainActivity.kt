package br.com.anestech.axreg_droid.activity

import android.os.Bundle
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.extensions.addFragment
import br.com.anestech.axreg_droid.fragments.LoginFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(R.id.content, LoginFragment())
    }
}
