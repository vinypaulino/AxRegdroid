package br.com.anestech.axreg_droid.database

import br.com.anestech.axreg_droid.models.State
import io.realm.Realm

class DbState {
    fun findStateByAcronym(acronym: String): State? {
        val realm = Realm.getDefaultInstance()
        val result = realm.copyFromRealm(realm.where(State::class.java).equalTo("acronym", acronym).findFirst())
        realm.close()
        return result
    }

    fun getAcronymState(): MutableList<State>? {
        val realm = Realm.getDefaultInstance()
        val result = realm.copyFromRealm(realm.where(State::class.java).findAll())
//        var acronym : ArrayList<String>? = null
//        var i = 0

        realm.close()
        return result
    }
}