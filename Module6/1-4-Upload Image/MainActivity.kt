package com.example.uploadimage

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import net.gotev.uploadservice.MultipartUploadRequest

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var imageView: ImageView
    lateinit var button2: Button
    lateinit var filepath: Uri
    lateinit var  bitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText=findViewById(R.id.edt1)
        button=findViewById(R.id.btn1)
        button2=findViewById(R.id.btn2)
        imageView=findViewById(R.id.img)


        button.setOnClickListener(this)
        button2.setOnClickListener(this)

        requestpermission()
    }

    private fun requestpermission()
    {
        if(checkSelfPermission(READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE),100)
        }
        else
        {
            Toast.makeText(applicationContext,"Permission alread granted",Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?)
    {
            if(v==button)
            {
                var i = Intent()
                i.type = "image/*"
                i.action = Intent.ACTION_GET_CONTENT
               // startActivityForResult(i,1)
                startActivityForResult(Intent.createChooser(i, "Select Picture"), 1)
            }
            if(v==button2)
            {
                val name = editText.getText().toString()
                val path = getPath(filepath)
                MultipartUploadRequest(this, Api.url)
                    .addFileToUpload(path, "url")
                    .addParameter("name", name)
                    .setMaxRetries(2)
                    .startUpload()
                Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT).show()
            }
    }
    @SuppressLint("Range")
    fun getPath(uri: Uri?): String
    {
        var cursor = contentResolver.query(uri!!, null, null, null, null)
        cursor!!.moveToFirst()
        var document_id = cursor.getString(0)
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null, MediaStore.Images.Media._ID + " = ? ", arrayOf(document_id), null)
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==1 && resultCode == RESULT_OK && data != null)
        {

            filepath = data.data!!
            bitmap= MediaStore.Images.Media.getBitmap(contentResolver, filepath)
            imageView.setImageBitmap(bitmap)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}