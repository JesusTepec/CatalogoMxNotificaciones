package controlmicatalogo.com.catalogomx.framework.reciever

import android.R
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class CatalogoMxMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val notification = NotificationCompat.Builder(this, "0")
            .setContentTitle(remoteMessage.notification?.title)
            .setContentText(remoteMessage.notification?.body)
            .setSmallIcon(R.drawable.ic_input_add)
            .build()
        val manager = NotificationManagerCompat.from(applicationContext)
        manager.notify(123, notification)
    }
}