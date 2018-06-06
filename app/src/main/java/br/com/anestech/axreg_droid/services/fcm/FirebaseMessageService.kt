package br.com.anestech.axreg_droid.services.fcm

import android.app.PendingIntent
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import br.com.anestech.axreg_droid.R
import br.com.anestech.axreg_droid.activity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.koushikdutta.async.http.HttpUtil.getBody
import com.google.firebase.messaging.RemoteMessage
import java.util.*


/**
 * Created by vinicius on 04/06/18.
 */
class FirebaseMessageService : FirebaseMessagingService() {

    val CHANNEL_ID = "axreg"
    val TAG = "@@@AxRegDroid"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.from)


        // Check if message contains a notification payload.
        if (remoteMessage.notification != null) {
            //  Log.d(TAG, "Message Notification Body: " + remoteMessage.notification.body!!)
            try {
                val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                        .setColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
                        .setContentTitle(remoteMessage.notification!!.title!!)
                        .setContentText(remoteMessage.notification!!.body!!)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setSmallIcon(R.drawable.ic_notification)

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("open_ads", true)
                intent.action = "open_ads"

                val contentIntent = PendingIntent.getActivity(this, Random().nextInt(),
                        intent, PendingIntent.FLAG_UPDATE_CURRENT)

                mBuilder.setContentIntent(contentIntent)

                val notificationManager = NotificationManagerCompat.from(this)
                notificationManager.notify(Random().nextInt(), mBuilder.build())

            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}