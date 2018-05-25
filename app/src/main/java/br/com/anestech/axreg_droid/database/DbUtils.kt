package br.com.anestech.axcalc.database

import br.com.anestech.axcalc.models.User
import io.realm.Realm

class DbUtils {
    companion object {

        fun getIdForUser(): Long{
            val realm = Realm.getDefaultInstance()
            val currentMaxId = realm.where(User::class.java).max("id")
            realm.close()

            when(currentMaxId == null){
                true -> return 1
                false -> return currentMaxId!!.toLong()+1
            }

        }
    }
}