package com.strayalpaca.tiffanyentropy.presentation.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.strayalpaca.tiffanyentropy.R
import com.strayalpaca.tiffanyentropy.domain.notification.repository.NotificationRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class SensorNotificationMessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var notificationRepository: NotificationRepository

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        CoroutineScope(Dispatchers.IO).launch {
            notificationRepository.sendFirebaseToken(token)
        }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val channelId = message.notification?.channelId ?: "113"

        val title = message.data.getOrDefault("title", "위험물질 수치 경고")
        val body = message.data.getOrDefault("body", "위험물질 수치가 허용 범위를 넘어섰습니다.")


        val notificationBuilder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(body)

        getSystemService(NotificationManager::class.java).run {
            val channel =
                NotificationChannel(channelId, "알림", NotificationManager.IMPORTANCE_DEFAULT)
            createNotificationChannel(channel)
            notify(Date().time.toInt(), notificationBuilder.build())
        }


        message.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }
    }
}