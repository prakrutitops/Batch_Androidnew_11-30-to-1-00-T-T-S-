package com.example.customtoastanddialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.sound_games)

        btn1.setOnClickListener {

            var toast = Toast(this)
            var layoutInflater:LayoutInflater = LayoutInflater.from(applicationContext)
            var view = layoutInflater.inflate(R.layout.design,null)
            toast.view=view
            toast.duration= Toast.LENGTH_LONG
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
        btn2.setOnClickListener {

            var alert = AlertDialog.Builder(this)
            var layoutInflater:LayoutInflater = LayoutInflater.from(applicationContext)
            var view = layoutInflater.inflate(R.layout.design2,null)
            var s1:Switch= view.findViewById(R.id.s1)
            s1.setOnCheckedChangeListener { buttonView, isChecked ->

                if(isChecked)
                {
                        mediaPlayer.start()
                }
                else
                {
                    mediaPlayer.stop()
                }

            }

            alert.setView(view)
            alert.show()


        }


    }
}