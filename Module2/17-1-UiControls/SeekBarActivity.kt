package com.example.uicontrolsex

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar

class SeekBarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    lateinit var image:ImageView
    lateinit var seek1:SeekBar
    lateinit var seek2:SeekBar
    lateinit var seek3:SeekBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)

        image = findViewById(R.id.img)
        seek1 = findViewById(R.id.seek1)
        seek2 = findViewById(R.id.seek2)
        seek3 = findViewById(R.id.seek3)


        seek1.setOnSeekBarChangeListener(this)
        seek2.setOnSeekBarChangeListener(this)
        seek3.setOnSeekBarChangeListener(this)



    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean)
    {
            var r = seek1!!.progress
            var g = seek2!!.progress
            var b = seek3!!.progress

            image.setBackgroundColor(Color.rgb(r,g,b))
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}