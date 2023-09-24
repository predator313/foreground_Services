package com.aamirashraf.foregroundservice

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
            ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }
        setContentView(R.layout.activity_main)
        //now request the permission of the manifest file as got some feel how to request the permission
        val btn1=findViewById<Button>(R.id.btn_start)
        val btn2=findViewById<Button>(R.id.btn_stop)
        btn1.setOnClickListener {
            Intent(
                applicationContext,

                RunningService::class.java
            ).also {
                it.action=RunningService.Actions.START.toString() //to start the service
                startService(it)
            }
        }
        btn2.setOnClickListener {
            Intent(
                applicationContext,
                RunningService::class.java
            ).also {
                it.action=RunningService.Actions.STOP.toString() //to stop the service
                startService(it)
            }
        }

    }
}