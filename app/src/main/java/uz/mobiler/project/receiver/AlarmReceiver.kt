package uz.mobiler.project.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import uz.mobiler.project.utils.NotificationHelper

class AlarmReceiver: BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {

       val notificationHelper = context?.let { NotificationHelper(it) }
        val notification = notificationHelper?.getNotification()
        notificationHelper?.getManager()?.notify(1, notification)

    }
}