package br.com.anestech.axcalc.database

import br.com.anestech.axcalc.models.Ad
import br.com.anestech.axcalc.models.User
import io.realm.Realm
import io.realm.RealmObject

class DbHelper {


    companion object {

        fun save(obj:RealmObject){
            val realm = Realm.getDefaultInstance()
            realm.beginTransaction()
            realm.insertOrUpdate(obj)
            realm.commitTransaction()
            realm.close()
        }

        fun findUser(): User? {
            val realm = Realm.getDefaultInstance()
            val user = realm.copyFromRealm(realm.where(User::class.java).findFirst())
            realm.close()
            return user
        }

        fun findAd(id: Long): Ad? {
            val realm = Realm.getDefaultInstance()
            val result = realm.copyFromRealm(realm.where(Ad::class.java).equalTo("id", id).findFirst())
            realm.close()
            return result
        }

    }
}