package com.example.serviceexample


//service - processes which are running in background

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyService : Service()
{

    override fun onBind(intent: Intent): IBinder
    {
        TODO("Return the communication channel to the service.")
    }

    override fun onStart(intent: Intent?, startId: Int)
    {
        Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()

        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(applicationContext,"Start Command",Toast.LENGTH_LONG).show()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy()
    {

        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
}