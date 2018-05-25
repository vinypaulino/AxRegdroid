package br.com.anestech.axcalc.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Ad (

        @PrimaryKey
        var id: Long = 0,
        var text: String = "",
        var link_text: String = "",
        var link_url: String = "",
        var image_url: String = ""

) : RealmObject(){

}