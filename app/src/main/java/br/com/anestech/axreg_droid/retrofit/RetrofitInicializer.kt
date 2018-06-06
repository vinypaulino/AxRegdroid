package br.com.anestech.axreg_droid.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by vinicius on 06/06/18.
 */
open class RetrofitInicializer() {

       private val retrofit = Retrofit.Builder()
               .baseUrl("http://dev.axreg-server.anestech.com.br/app")
               .addConverterFactory(GsonConverterFactory.create())
               .build()


}