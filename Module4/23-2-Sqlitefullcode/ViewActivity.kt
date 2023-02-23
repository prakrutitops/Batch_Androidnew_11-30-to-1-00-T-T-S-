package com.example.sqlitedbex

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import com.example.sqlitedbex.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity()
{

    lateinit var list: MutableList<Model>
    lateinit var dbHelper: DbHelper
    private lateinit var binding: ActivityViewBinding
    var arrayList: ArrayList<HashMap<String,String>> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        dbHelper = DbHelper(applicationContext)

       list =  dbHelper.viewdata()
        for(i in list)
        {
            var map = HashMap<String,String>()
            map.put("name",i.name)
            map.put("number",i.num)
            arrayList.add(map)

        }


        var from = arrayOf("name","number")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter=SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.list.adapter=adapter

        registerForContextMenu(binding.list)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {

        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")

        super.onCreateContextMenu(menu, v, menuInfo)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos = acm.position
        val m = list!![pos]

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",m.id)
                i.putExtra("name",m.name)
                i.putExtra("number",m.num)
                startActivity(i)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to Delete?")
                alert.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->

                    dbHelper.deletedata(m.id)
                    startActivity(Intent(applicationContext,ViewActivity::class.java))

                })
                alert.setNegativeButton("NO",{
                        dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()

                })
                alert.show()
            }
        }


        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}