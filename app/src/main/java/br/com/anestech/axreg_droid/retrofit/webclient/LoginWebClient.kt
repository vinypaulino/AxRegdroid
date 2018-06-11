package br.com.anestech.axreg_droid.retrofit.webclient

import android.util.Log
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.retrofit.RetrofitInicializer
import br.com.anestech.axreg_droid.retrofit.response.CallbackResponse
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

/**
 * Created by vinicius on 07/06/18.
 */
class LoginWebClient {
    fun login(email: String, password: String, callbackResponse: CallbackResponse<User> ) {

        val teste : String = "teste vinicius"
        Log.e("teste", teste)

        val call = RetrofitInicializer().loginService().login(email, password)
        call.enqueue(object : retrofit2.Callback<User> {

            override fun onResponse(call: Call<User>?, response: Response<User>?) {
                response?.body()?.let {
                    val userResponse: User = it
                    callbackResponse.success(userResponse)
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
}



