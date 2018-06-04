package br.com.anestech.axreg_droid.services.fcm

import android.util.Log
import br.com.anestech.axcalc.services.api.AxServerApi
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.messaging.FirebaseMessaging

class FirebaseInstanceIDService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        // Get updated InstanceID token.
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d("@@@AxReg", "Refreshed token: " + refreshedToken!!)

        FirebaseMessaging.getInstance().subscribeToTopic("axcalc")

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken)
    }

    private fun sendRegistrationToServer(refreshedToken: String) {
        try{
            AxServerApi.registerForNotifications(this, refreshedToken)
        }catch (ex:Exception){
            ex.printStackTrace()
        }
    }

}