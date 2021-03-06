package br.com.anestech.axreg_droid.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

/**
 * Created by vinicius on 06/06/18.
 */
open class CrmAnesthetist (
        @PrimaryKey
        var id: Long? = null,
        var uuid: String = "",
        var updateAt:Date? = null,
        var active: Boolean = true,

        var crm:String = "",
        var state: State? = null

) : RealmObject()