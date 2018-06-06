package br.com.anestech.axreg_droid.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by vinicius on 06/06/18.
 */
open class State(
        @PrimaryKey
        var id: Long = 1,
        var name: String = "",
        var acronym: String = ""

        ) : RealmObject()