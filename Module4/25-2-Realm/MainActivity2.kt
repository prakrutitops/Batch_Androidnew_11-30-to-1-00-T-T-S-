package com.example.realmdb

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.realmdb.databinding.ActivityMain2Binding
import io.realm.Realm

class MainActivity2 : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    private lateinit var binding: ActivityMain2Binding
    lateinit var list:MutableList<Model>
    lateinit var realm: Realm
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        realm = Realm.getInstance(Realm.getDefaultConfiguration())
        list = ArrayList()

        realm.beginTransaction()

        var realmResults = realm.where(Model::class.java).findAll()

        for(i in realmResults.indices)
        {
            list.add(realmResults[i]!!)
        }

        var adpater = MyAdapter(applicationContext,list)
        binding.list.adapter=adpater

        realm.commitTransaction()

        binding.list.setOnItemLongClickListener(this)


    }

    @SuppressLint("MissingInflatedId")
    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Select Operations?")
        alert.setPositiveButton("Update", { dialogInterface: DialogInterface, i: Int ->

            var alertDialog2=AlertDialog.Builder(this)
            var inflater= LayoutInflater.from(this)
            var view =inflater.inflate(R.layout.edit,null)
            var edit1: EditText =view.findViewById(R.id.edt1)
            var edit2:EditText =view.findViewById(R.id.edt2)

            alertDialog2.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                var name =edit1.text.toString()
                var pass=edit2.text.toString()

                realm.beginTransaction()

                list.get(position).name =name
                list.get(position).pass =pass


                realm.commitTransaction()
                startActivity(Intent(this,MainActivity2::class.java))

            })

            alertDialog2.setView(view)

            realm.beginTransaction()
            var realmResults = realm.where(Model::class.java).findAll()

            edit1.setText(realmResults.get(position)!!.name)
            edit2.setText(realmResults.get(position)!!.pass)

            realm.commitTransaction()
            alertDialog2.show()

        })
        alert.setNegativeButton("Delete", { dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()
            var realmResults = realm.where(Model::class.java).findAll()
            realmResults.deleteFromRealm(position)
            realm.commitTransaction()
            startActivity(Intent(applicationContext, MainActivity2::class.java))

        })
        alert.show()


    return true
    }
}