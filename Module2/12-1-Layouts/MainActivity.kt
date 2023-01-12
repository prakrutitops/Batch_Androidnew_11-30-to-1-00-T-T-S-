package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.gridlayout)

        linearLayout = LinearLayout(this)

        var text1:TextView = TextView(this)
        text1.setText("Hello From Tops")

        var width= 500
        var height = 500

        linearLayout.addView(text1,width,height)
        setContentView(linearLayout)

    }
}