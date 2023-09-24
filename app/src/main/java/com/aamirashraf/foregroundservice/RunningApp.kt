package com.aamirashraf.foregroundservice

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class RunningApp:Application() {
    //this is the application
    //in this onCreate we need to make the notification channel of service class
    //only once as the time when the application boot ups
    //we need to register this class in manifest also
    override fun onCreate() {
        super.onCreate()
        //notification channels are implemented after android oreo so we need to put the checks for that
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            //now create the channel
            val channel=NotificationChannel(
                "running_channel",  //id should be same as in service class
                 "running Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            //now get access to the system service  most important step
            val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}