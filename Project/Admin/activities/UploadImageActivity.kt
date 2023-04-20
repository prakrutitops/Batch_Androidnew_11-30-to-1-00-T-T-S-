package com.example.final_project_admin_side

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.classprojectadmin.apis.Api
import net.gotev.uploadservice.MultipartUploadRequest

class UploadImageActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var imageView: ImageView
    private lateinit var filePath: Uri
    private lateinit var bitmap: Bitmap
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)

        editText = findViewById(R.id.edt1)
        button = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        imageView = findViewById(R.id.img)

        button.setOnClickListener(this)
        button2.setOnClickListener(this)

        requestPermission()
    }

    private fun requestPermission() {
        if (checkSelfPermission(READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(READ_EXTERNAL_STORAGE),
                100
            )
        } else {
            Toast.makeText(applicationContext, "External storage permission already granted.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v) {

            button-> {
                val i = Intent()
                i.type = "image/*"
                i.action = Intent.ACTION_GET_CONTENT
                startActivityForResult(Intent.createChooser(i, "Select image"), 1)
            }

            button2-> {
                val name = editText.text.toString()
                val path = getPath(filePath)
                MultipartUploadRequest(this, Api.url)
                    .addFileToUpload(path, "url")
                    .addParameter("name", name)
                    .setMaxRetries(2)
                    .startUpload()
                Toast.makeText(applicationContext, "Uploaded", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("Range")
    private fun getPath(filePath: Uri): String {
        var cursor = contentResolver.query(filePath, null, null, null, null)
        cursor!!.moveToFirst()
        var documentId = cursor.getString(0)
        documentId = documentId.substring(documentId.lastIndexOf(":") + 1)
        cursor.close()
        cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            null,
            MediaStore.Images.Media._ID + " = ? ",
            arrayOf(documentId),
            null,
        )
        cursor!!.moveToFirst()
        val path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
        cursor.close()
        return path
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            filePath = data.data!!
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
            imageView.setImageBitmap(bitmap)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.logOut -> {
                sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)
                sharedPreferences.edit().clear().apply()
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}