package com.example.audiovideoex


import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


class MainActivity2 : AppCompatActivity(), SurfaceHolder.Callback {
    var url="https://vyasprakruti.000webhostapp.com/movie.mp4"
   /* lateinit var videoView: VideoView*/
   lateinit var mediaPlayer: MediaPlayer
    lateinit var surfaceView: SurfaceView
    lateinit var holder: SurfaceHolder


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


       /* videoView=findViewById(R.id.videoView)*/

      /*  try
        {
            val mediaController = MediaController(this)
            mediaController.setAnchorView(videoView)
            val video: Uri = Uri.parse(url)
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(video)
            videoView.start()
        } catch (e: Exception) {
            // TODO: handle exception
            Toast.makeText(this, "Error connecting", Toast.LENGTH_SHORT).show()
        }*/


        //-------------------------------------------------------------------


        surfaceView = findViewById<SurfaceView>(R.id.surfaceView)
        mediaPlayer = MediaPlayer()
        holder = surfaceView.holder
        holder.setFixedSize(800, 480)
        holder.addCallback(this)
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)






    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        mediaPlayer.setDisplay(holder)
        play()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }
    private fun play() {
        try {
            mediaPlayer.setDataSource(url)
            mediaPlayer.prepare()
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        mediaPlayer.start()
    }
}