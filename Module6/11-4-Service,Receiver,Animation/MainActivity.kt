package com.example.serviceexample

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.graphics.drawable.AnimationDrawable
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView


//frame by frame
//View
//Layout

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var image:ImageView
    lateinit var anim:AnimationDrawable

    @SuppressLint("MissingInflatedId", "WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        image = findViewById(R.id.img)
        animationdata()
        anim = image.background as AnimationDrawable
        var receiver = MyReceiver()
        var i = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        i.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver,i)

        btn1.setOnClickListener {

            var i = Intent(applicationContext,MyService::class.java)
            startService(i)

        }
        btn2.setOnClickListener {

            /*var i = Intent(applicationContext,MyService::class.java)
            stopService(i)*/

            if(anim.isRunning())
            {
                anim.stop()
            }
            else
            {
                anim.start()
            }
        }
    }

    private fun animationdata()
    {
      /* var data = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate)
       image.startAnimation(data)*/
    }
}