package br.com.anestech.axreg_droid.fragments.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.anestech.axcalc.models.User
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.LoginActivity
import br.com.anestech.axreg_droid.activity.MainActivity
import br.com.anestech.axreg_droid.extensions.toast
import br.com.anestech.axreg_droid.fragments.BaseFragment
import br.com.anestech.axreg_droid.retrofit.response.CallbackResponse
import br.com.anestech.axreg_droid.retrofit.webclient.LoginWebClient
import br.com.anestech.axreg_droid.utils.Prefs
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_login.*
import org.jetbrains.anko.support.v4.startActivity

class LoginFragment : BaseFragment() {
    var loginActivity: LoginActivity = LoginActivity()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginActivity = activity as LoginActivity

        txt_forgout_my_pass.setOnClickListener {
            loginActivity.openForgotPassword()
        }

        txt_create_account.setOnClickListener {
            loginActivity.toast("Criar Conta ! ")
        }
        btn_login.setOnClickListener {
            login()
        }
    }

    fun login() {
        val email = edt_login_email.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")
        val password = edt_login_password.text.toString().trim().takeUnless { it.isNullOrEmpty() }?.toString()
                ?: throw IllegalArgumentException("empty fields")

        LoginWebClient().login(email, password, object : CallbackResponse<User> {
            override fun responseFailure() {
                activity?.toast(R.string.user_password_invalid)
                edt_login_email.setText("")
                edt_login_password.setText("")
            }

            override fun failure(throwable: Throwable) {
                activity?.toast(R.string.failure_server)
                Log.e("OnFailure", "login nao realizado")

            }

            override fun success(response: User) {
                insertUserRealm(response)

                insertUserPrefs(response)

                startActivity<MainActivity>()
                activity?.finish()
            }
        })
    }

    private fun insertUserPrefs(response: User) {
        Prefs.setString("uuid", response.uuid)
        Prefs.setString("email", response.email)
        Prefs.setString("token", response.token)
    }

    private fun insertUserRealm(response: User) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            realm.insertOrUpdate(response)
        }
        realm.close()
    }
}







