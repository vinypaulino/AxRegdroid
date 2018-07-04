package br.com.anestech.axreg_droid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.fragments.RegisterFragment

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, RegisterFragment.newInstance())
                    .commitNow()
        }
    }

}
