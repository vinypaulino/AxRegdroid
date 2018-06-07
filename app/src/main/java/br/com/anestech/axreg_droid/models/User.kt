package br.com.anestech.axcalc.models

import br.com.anestech.axcalc.database.DbUtils
import br.com.anestech.axreg_droid.models.Anesthetist
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class User (

        @PrimaryKey
        var id: Long = 0,
        var uuid: String = "",
        var email: String = "",
        var password: String = "",
        var passwordDate: Date = Date(),
        var anesthetist: Anesthetist? = null,
        var accessToken: String = "",
        var updatedAt: Date = Date(),
        var validationCode: String = "",
        var validated: Boolean = false,
        var active: Boolean = false,
        var validatedDate: Date = Date(),
        var forceLogout: Boolean = true,


        var pictureUrl: String = "",
        var facebookUrl: String = "",
        var googleUrl: String = ""


) : RealmObject(){}