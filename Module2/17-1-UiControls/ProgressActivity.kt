package com.example.uicontrolsex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class ProgressActivity : AppCompatActivity()
{
    lateinit var pb:ProgressBar
    lateinit var btn1:Button
    lateinit var btn2:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)


        pb = findViewById(R.id.pb)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)


        btn1.setOnClickListener {

            pb.incrementProgressBy(1)
            setProgress(100*pb.progress)

        }
        btn2.setOnClickListener {

            pb.incrementProgressBy(-1)
            setProgress(100*pb.progress)

        }

    }
}