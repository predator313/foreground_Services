package com.aamirashraf.foregroundservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class RunningService:Service() {
    //we need to register the service in manifest file
    override fun onBind(p0: Intent?): IBinder? {
        //IBinder is used to create the bind service
        //means one active instance of service and multiple app components can interact with it
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString()->start()
            Actions.STOP.toString()->stopSelf() //this function stops the instance of the service
        }
        return super.onStartCommand(intent, flags, startId)
        //this function got triggered when the other android components
        //sends intents to this service
    }
    private fun start(){
        //as we know that for the foreground service we need notifications
        val notification=NotificationCompat.Builder(
            this,
            "running_channel"      //also we need to create this notification channel inside the application class
        ).setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Run is Active")
            .setContentText("service is running ......")
            .build()
        startForeground(1,notification) //this is the inbuilt function to start foreground service id>=1
    }
    enum class Actions{
        START,STOP
    }
}