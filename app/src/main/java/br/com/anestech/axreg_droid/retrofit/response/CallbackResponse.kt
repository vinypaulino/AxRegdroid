package br.com.anestech.axreg_droid.retrofit.response

import br.com.anestech.axcalc.models.User

/**
 * Created by vinicius on 07/06/18.
 */
interface CallbackResponse<T> {
    fun success(response: T)

    fun failure(throwable: Throwable)
}