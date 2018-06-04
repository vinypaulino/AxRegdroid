package br.com.anestech.axreg_droid.activity

import android.os.Bundle
import br.com.anestech.axcalc.activities.main.ads.AdsGalleryFragment
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.extensions.addFragment
import br.com.anestech.axreg_droid.extensions.setupToolbar
import br.com.anestech.axreg_droid.fragments.LoginFragment
import br.com.anestech.axreg_droid.fragments.RecoverPasswordFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar(R.id.toolbar, "Main activity", true)


    }


    private fun loadFragmentAds() {
        supportFragmentManager.beginTransaction()
                .add(R.id.content, AdsGalleryFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }


}
