package com.example.permissionex

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{
    lateinit var linearLayout: LinearLayout
    lateinit var img: ImageView
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayout = findViewById(R.id.linear)
        img= findViewById(R.id.img)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var i = Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,200)

        }

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED && checkSelfPermission(CAMERA)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CAMERA, CALL_PHONE),100)

        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {

        if(requestCode == 100)
        {
            Snackbar.make(linearLayout,"Permission Granted",Snackbar.LENGTH_LONG).show()



        }
        else
        {
            Snackbar.make(linearLayout,"Permission Denied",Snackbar.LENGTH_LONG).show()
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==200)
        {
            var bm:Bitmap = data!!.extras!!.get("data") as Bitmap
            img.setImageBitmap(bm)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}