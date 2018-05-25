package br.com.anestech.axcalc.services.api.responses

import com.google.gson.JsonObject

/**
 * Created by Vinicius Paulino on 24/05/18.
 */
class RegistrationResponse(
        var status_id: Int,
        var status_msg: String,
        var data:JsonObject) {}