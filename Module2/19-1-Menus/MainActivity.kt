package com.example.menusexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast


class MainActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        btn1 = findViewById(R.id.btn1)


        list.add("Java")
        list.add("Android")
        list.add("Flutter")


        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter


        registerForContextMenu(listView)


        btn1.setOnClickListener {


            var popup1 :PopupMenu= PopupMenu(this,btn1)
            popup1.menuInflater.inflate(R.menu.popup,popup1.menu)
            popup1.setOnMenuItemClickListener(this)
            popup1.show()




        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"Logout",Toast.LENGTH_LONG).show()
            }
            R.id.i2->
            {
                Toast.makeText(applicationContext,"Login",Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var abc :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = abc.position
        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,"Position Called:  "+ id,Toast.LENGTH_LONG).show()
            }
        }

        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean
    {
        when(item!!.itemId)
        {
                R.id.movie->
                {
                    Toast.makeText(applicationContext,"Movie Called",Toast.LENGTH_LONG).show()
                }
        }
        return false
    }


}