package br.com.anestech.axcalc.models

import br.com.anestech.axcalc.database.DbUtils
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User (

        @PrimaryKey
        var id: Long = DbUtils.getIdForUser(),

        var name: String = "",
        var email: String = "",
        var pictureUrl: String = "",
        var facebookUrl: String = "",
        var googleUrl: String = "",
        var uuid: String = "",
        var activated: Boolean = false

) : RealmObject(){}