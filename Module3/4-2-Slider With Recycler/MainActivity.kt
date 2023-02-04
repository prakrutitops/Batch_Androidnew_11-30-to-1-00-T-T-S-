package com.example.sliderlayoutex

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.example.sliderlayoutex.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()

        var layoutmanager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager=layoutmanager

        list.add(Model(R.drawable.v1,"1000"))
        list.add(Model(R.drawable.v2,"2000"))
        list.add(Model(R.drawable.v3,"3000"))
        list.add(Model(R.drawable.v4,"4000"))

        list.add(Model(R.drawable.v1,"1000"))
        list.add(Model(R.drawable.v2,"2000"))
        list.add(Model(R.drawable.v3,"3000"))
        list.add(Model(R.drawable.v4,"4000"))

        list.add(Model(R.drawable.v1,"1000"))
        list.add(Model(R.drawable.v2,"2000"))
        list.add(Model(R.drawable.v3,"3000"))
        list.add(Model(R.drawable.v4,"4000"))

        var myAdapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter=myAdapter


        var map = HashMap<String,Int>()
        map.put("Vivo v20",R.drawable.v1)
        map.put("Vivo v22",R.drawable.v2)
        map.put("Vivo v24",R.drawable.v3)
        map.put("Vivo v30",R.drawable.v4)

        for (i in map.keys)
        {
            val textSliderView = TextSliderView(this)

            textSliderView.description(i).image(map.get(i)!!)
            binding.slider.addSlider(textSliderView)

        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {

            }
        }
        return super.onOptionsItemSelected(item)
    }
}