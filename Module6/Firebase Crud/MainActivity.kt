package com.example.firebasecrudapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity()
{

    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1: Button
    lateinit var btn2:Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        edt3 = findViewById(R.id.edt3)
        btn1 = findViewById(R.id.btninsert)
        btn2 = findViewById(R.id.btnview)



        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var email = edt2.text.toString()
            var pass = edt3.text.toString()

            var map = HashMap<String,String>()
            map["name"]=name
            map["email"]=email
            map["password"]=pass


            var db = FirebaseDatabase.getInstance().getReference()
                            .child("tops")
                            .push()
                            .setValue(map)
                            .addOnSuccessListener {

                                Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(applicationContext, MainActivity2::class.java))

                            }
                            .addOnFailureListener{

                                Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                            }


        }
        btn2.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

    }
}