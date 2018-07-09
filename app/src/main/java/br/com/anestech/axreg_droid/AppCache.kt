package br.com.anestech.axcalc


import android.app.Application
import br.com.anestech.axcalc.database.DbInitialData
import br.com.anestech.axcalc.models.User
import io.realm.Realm
import io.realm.RealmConfiguration


/**
 * Created by Viny Paulino on 24/05/18.
 */

class AppCache : Application() {

    override fun onCreate() {
        super.onCreate()
        configAndInitRealm()
        appInstance = this
    }

    /**
     * Responsible for initialize and configure Realm database with initial data
     */
    private fun configAndInitRealm() {
        Realm.init(this)

        val config = RealmConfiguration.Builder()
              //  .initialData(DbInitialData())
                .name("axreg.realm")
                .deleteRealmIfMigrationNeeded()
                .build()

        Realm.setDefaultConfiguration(config)
    }

    companion object {
        var appInstance: AppCache? = null
        fun getInstance(): AppCache {
            if (appInstance == null){
                throw IllegalStateException("Configure a classe Application no AndroidManifest.xml")
            }
            return appInstance!!
        }
        //var currentUser: User? = null
//        private var tracker: Tracker? = null
//        @Synchronized
//        fun getDefaultTracker(ctx: Context): Tracker {
//            if (tracker == null) {
//                val analytics = GoogleAnalytics.getInstance(ctx)
//                tracker = analytics.newTracker("UA-85326028-4")
//            }
//            return tracker!!
//        }
    }
}
