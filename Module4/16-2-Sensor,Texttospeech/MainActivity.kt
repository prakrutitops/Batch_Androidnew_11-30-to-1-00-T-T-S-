package com.example.a

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var edt1:EditText
    lateinit var btn1:Button
    lateinit var tts:TextToSpeech

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        btn1 = findViewById(R.id.btn1)
        tts = TextToSpeech(applicationContext,this)
        btn1.setOnClickListener {

            tts.setLanguage(Locale.UK)
            tts.setPitch(0.9F)
            tts.setSpeechRate(0.9F)


            var data = edt1.text.toString()
            tts.speak(data,QUEUE_ADD,null)



        }

    }

    override fun onInit(p0: Int)
    {
            if(p0 == TextToSpeech.SUCCESS)
            {
                Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
            }
            else if(p0==TextToSpeech.LANG_MISSING_DATA)
            {
                Toast.makeText(applicationContext,"Missing Data",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }

    }
}