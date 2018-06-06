package br.com.anestech.axreg_droid.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by vinicius on 06/06/18.
 */
open class Country (
        @PrimaryKey
       var id: Long = 1,
       var name: String = ""
): RealmObject()