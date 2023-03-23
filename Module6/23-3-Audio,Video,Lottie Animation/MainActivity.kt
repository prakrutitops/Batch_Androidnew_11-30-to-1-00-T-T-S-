package com.example.audiovideoex

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener {
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var mediaPlayer: MediaPlayer
    var url="https://vyasprakruti.000webhostapp.com/iphone_13_original.mp3"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
       /* mediaPlayer = MediaPlayer.create(applicationContext,R.raw.iphone_13_original)*/
        mediaPlayer = MediaPlayer()
        btn1.setOnClickListener {

            mediaPlayer.setDataSource(url)
            mediaPlayer.prepareAsync()
            mediaPlayer.setOnPreparedListener(this)
            mediaPlayer.start()

/*

            var file= Environment.getExternalStorageDirectory();
            file=new File(file,"song.mp3");

            if(file.exists())
            {
                Uri uri = Uri.fromFile(file);
                mediaPlayer = MediaPlayer.create(this,uri);
                mediaPlayer.start();
            }
*/


        }
        btn2.setOnClickListener {

            mediaPlayer.stop()


        }

    }

    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer.start();
    }
}