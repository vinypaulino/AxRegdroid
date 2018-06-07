package br.com.anestech.axreg_droid.retrofit.service

import br.com.anestech.axcalc.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by vinicius on 07/06/18.
 */
interface LoginService {

    @POST("login")
    fun login(@Body user: User): Call<User>
}