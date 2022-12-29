package com.tops.calldata

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var img:ImageView
    lateinit var txt:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img1)
        txt = findViewById(R.id.txt1)

        //explicit
        img.setOnClickListener {

                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)

        }
        //implicit
        txt.setOnClickListener {

                var num ="8849817263"
                var i =Intent()
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)
        }
    }
}