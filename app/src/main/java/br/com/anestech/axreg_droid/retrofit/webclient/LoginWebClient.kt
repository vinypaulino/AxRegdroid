package br.com.anestech.axreg_droid.retrofit.webclient

import android.util.Log
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.retrofit.RetrofitInicializer
import br.com.anestech.axreg_droid.retrofit.response.CallbackResponse
import retrofit2.Call
import retrofit2.Response

/**
 * Created by vinicius on 07/06/18.
 */
class LoginWebClient {
    fun login(email: String, password: String, callbackResponse: CallbackResponse<User> ) {

        val call = RetrofitInicializer().loginService().login(email, password)
        call.enqueue(object : retrofit2.Callback<User> {

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response?.isSuccessful!!){
                    val userResponse: User = response.body()!!
                    callbackResponse.success(userResponse)
                } else if (response?.code() == 401){
                    callbackResponse.responseFailure()
                }
            }

            override fun onFailure(call: Call<User>?, t: Throwable?) {
                t?.message?.let {
                    callbackResponse.failure(t!!)
                    Log.e("onFailure error", t?.message)
                }
            }
        })
    }

    fun register(user: User, callbackResponse: CallbackResponse<User>){
        val call = RetrofitInicializer().loginService().register(user)
        call.enqueue(object : retrofit2.Callback<User>{
            override fun onFailure(call: Call<User>?, t: Throwable?) {
                t?.message?.let {
                    callbackResponse.failure(t!!)
                    Log.e("onFailure error", t?.message)
                }
            }

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                if (response?.isSuccessful!!){
                    val userResponse: User = response.body()!!
                    callbackResponse.success(userResponse)
                } else if (response?.code() == 401){
                    callbackResponse.responseFailure()
                }
            }
        })
    }

    fun passwordReset(email: String, callbackResponse: CallbackResponse<String>){

        val call = RetrofitInicializer().loginService().passwordReset(email)
        call.enqueue(object : retrofit2.Callback<String>{

            override fun onResponse(call: Call<String>?, response: Response<String>?){
                if (response?.message() == "OK"){
                    callbackResponse.success(response = response.body()!!)
                } else {
                    callbackResponse.responseFailure()
                }
            }

            override fun onFailure(call: Call<String>?, t: Throwable?){
                callbackResponse.failure(t!!)
                Log.e("onFailureteste", "Falha na comunicação com o servidor ${call.toString()}")
                t?.printStackTrace()
            }
        })
    }
}



