package br.com.anestech.axreg_droid.database

import br.com.anestech.axreg_droid.models.CrmAnesthetist
import io.realm.Realm

class DbCrmAnesthetist {

    fun getListCrm(): MutableList<CrmAnesthetist>?{
        val realm = Realm.getDefaultInstance()
        val result = realm.copyFromRealm(realm.where(CrmAnesthetist::class.java).findAll())
        realm.close()
        return result
    }
}
