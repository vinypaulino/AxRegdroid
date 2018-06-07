package br.com.anestech.axreg_droid.retrofit.webclient

import android.util.Log
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.retrofit.RetrofitInicializer
import br.com.anestech.axreg_droid.retrofit.callback
import retrofit2.Call
import retrofit2.Response

/**
 * Created by vinicius on 07/06/18.
 */
class LoginWebClient {
    fun login(user: User, success: (user: User) -> Unit,
              failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInicializer().loginService().login(user)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                val user: User = it
                Log.d("Usuario", user.toString())
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))

    }
}

