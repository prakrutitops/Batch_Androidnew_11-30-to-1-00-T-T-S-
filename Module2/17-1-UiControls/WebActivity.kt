package com.example.uicontrolsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebActivity : AppCompatActivity()
{
    lateinit var web:WebView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        web = findViewById(R.id.web)
        web.loadUrl("https://careercenter.tops-int.com/")
    }
}