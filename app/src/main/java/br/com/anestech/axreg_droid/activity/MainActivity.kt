package br.com.anestech.axreg_droid.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.anestech.axcalc.activities.main.ads.AdsGalleryFragment
import br.com.anestech.axcalc.services.api.AxServerApi
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.extensions.setupToolbar
import org.jetbrains.anko.doAsync

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar(R.id.toolbar, "Main activity", true)

    }

    override fun onResume() {
        super.onResume()
        doAsync {
            AxServerApi.syncAds(applicationContext)
        }

        try {
            val action = intent.action
            if (action == "open_ads") {
                loadFragmentAds()
                intent.action = null
            }
        }catch (ex: Exception){
            ex.printStackTrace()
        }
    }

    private fun loadFragmentAds() {
        supportFragmentManager.beginTransaction()
                .add(R.id.content, AdsGalleryFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_ads) {
            loadFragmentAds()
        }
        return super.onOptionsItemSelected(item)
    }

}
