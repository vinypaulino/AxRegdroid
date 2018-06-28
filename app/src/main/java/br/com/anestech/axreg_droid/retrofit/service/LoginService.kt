package br.com.anestech.axreg_droid.retrofit.service

import br.com.anestech.axcalc.models.User
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by vinicius on 07/06/18.
 */
interface LoginService {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email: String, @Field("password") password: String): Call<User>

    @FormUrlEncoded
    @POST("users/passwordReset")
    fun passwordReset(@Field("email") email: String): Call<String>

    @POST("new/users")
    fun register(@Body user: User) : Call<User>
}