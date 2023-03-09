package com.example.jsoncrudex

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsoncrudex.databinding.ActivityMain2Binding
import org.json.JSONArray
import org.json.JSONException

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var list:MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        registerForContextMenu(binding.list)

        var stringRequest = StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productview.php",{response->try {

            var jsonarray = JSONArray(response)
            for(i in 0 until  jsonarray.length())
            {
                var jsonobject = jsonarray.getJSONObject(i)

                var id = jsonobject.getString("product_id")
                var name = jsonobject.getString("product_name")
                var price = jsonobject.getString("product_price")
                var des = jsonobject.getString("product_description")

                var m = Model()
                m.product_id=id
                m.product_name=name
                m.product_price=price
                m.product_des=des
                list.add(m)

            }

            var adapter = MyAdapter(applicationContext,list)
            binding.list.adapter=adapter
        }
        catch (e:JSONException)
        {
            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
        }
        })
        {
            Toast.makeText(applicationContext,"No INERNET",Toast.LENGTH_LONG).show()
        }
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


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
        var id = acm.position
        val m = list[id]

        when(item.itemId)
        {
            1->
            {

                    var i = Intent(applicationContext,MainActivity3::class.java)
                    i.putExtra("id",m.product_id)
                    i.putExtra("name",m.product_name)
                    i.putExtra("price",m.product_price)
                    i.putExtra("des",m.product_des)
                    startActivity(i)

            }


            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to Delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->


                    var stringRequest:StringRequest = object :StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productdelete.php",Response.Listener {

                        Toast.makeText(applicationContext,"DELETED",Toast.LENGTH_LONG).show()
                        startActivity(Intent(applicationContext,MainActivity2::class.java))
                    },Response.ErrorListener {
                        Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                    })
                    {
                        override fun getParams(): MutableMap<String, String>?
                        {
                            var map = HashMap<String,String>()
                            map.put("product_id",m.product_id)
                            return map
                        }
                    }

                    var queue:RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringRequest)


                })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })

                alert.show()
            }
        }



        return super.onContextItemSelected(item)
    }
}