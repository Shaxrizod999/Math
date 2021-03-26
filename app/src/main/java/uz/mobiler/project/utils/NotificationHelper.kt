package uz.mobiler.project.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.content.ContextWrapper
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import uz.mobiler.project.R

@RequiresApi(Build.VERSION_CODES.O)
class NotificationHelper(context: Context): ContextWrapper(context) {

    private val channelId = "alarm_channel"
    private val channelName = "alarm_channel_name"
    private var manager: NotificationManager? = null

    init {
        getManager()
        createChannel()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel() {

        val soudUri =
                    Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + applicationContext.packageName + "/")
        val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH).apply {
            enableVibration(true)
            vibrationPattern = longArrayOf(0L, 300L, 300L, 300L)

            val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build()
            setSound(soudUri, audioAttributes)
        }
        manager?.createNotificationChannel(channel)
    }

     fun  getManager(): NotificationManager? {
        if(manager == null)
        {
            manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        }
        return manager
    }

    fun getNotification(): Notification?
     {

        return NotificationCompat.Builder(applicationContext, channelId)
                .setContentTitle("Alarm !")
                .setContentText("Testni ishlash vaqti tugadi !!!")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
                .build()
    }

}