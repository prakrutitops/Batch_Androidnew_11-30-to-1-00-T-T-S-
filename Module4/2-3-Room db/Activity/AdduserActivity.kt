package com.example.roomdb.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.roomdb.Database.DatabaseClass
import com.example.roomdb.Entity.User
import com.example.roomdb.R
import com.example.roomdb.databinding.ActivityAdduserBinding
import com.example.roomdb.databinding.ActivityMainBinding
import com.example.roomdb.globalVariables.GlobalVariables

class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    lateinit var db:DatabaseClass
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)


        if (GlobalVariables.updateFlag.equals("update"))
        {
            edt1.setText(GlobalVariables.name)
            edt2.setText(GlobalVariables.email)
        }

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var email = edt2.text.toString()

            if (GlobalVariables.updateFlag.equals("update"))
            {
                var u = User()
                u.id=GlobalVariables.id
                u.name=name
                u.email=email

                db!!.daoClass().updateuser(u)
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show();
                GlobalVariables.updateFlag = "";

                startActivity(Intent(this,MainActivity::class.java))
            }
            else {




                var u = User()
                u.name = name
                u.email = email

                db!!.daoClass().addUser(u)
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }

        }

    }
}