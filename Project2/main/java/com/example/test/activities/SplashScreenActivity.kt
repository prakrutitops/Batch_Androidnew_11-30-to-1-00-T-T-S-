package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.test.IntroSliderActivity
import com.example.test.R



class SplashScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler()
            .postDelayed({
                startActivity(
                    Intent(
                        applicationContext,
                        IntroSliderActivity::class.java
                    )
                )
                finish()
            }, 1000)
    }
}