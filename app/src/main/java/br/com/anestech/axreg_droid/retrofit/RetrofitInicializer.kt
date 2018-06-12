package br.com.anestech.axreg_droid.retrofit

import br.com.anestech.axreg_droid.retrofit.service.LoginService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vinicius on 06/06/18.
 */
class RetrofitInicializer() {
    private var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client : OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(interceptor)

    val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://dev.axreg-server.anestech.com.br/app/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client.build())
            .build()

    fun loginService() = retrofit.create(LoginService::class.java)

}