package com.example.finalproject_batch_1130.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject_batch_1130.Activity.CategoryActivity
import com.example.finalproject_batch_1130.Activity.FullScreenActivity
import com.example.finalproject_batch_1130.Model.CategoryModel
import com.example.finalproject_batch_1130.Model.DashboardModel
import com.example.finalproject_batch_1130.R
import com.squareup.picasso.Picasso
import retrofit2.Call

class CategoryAdapter(var context: Context,var list:MutableList<CategoryModel>) :RecyclerView.Adapter<MyView2>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView2
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.category_design,parent,false)
        return MyView2(view)
    }

    override fun onBindViewHolder(holder: MyView2, position: Int)
    {

        Picasso.get().load(list.get(position).image).into(holder.img1)
        holder.txt1.setText(list.get(position).gift_name)
        holder.txt2.setText(list.get(position).gift_price)
        holder.txt3.setText(list.get(position).gift_description)
        holder.img1.setOnClickListener {

            var i = Intent(context, FullScreenActivity::class.java)
            i.putExtra("pos",list.get(position).image)
            i.putExtra("pos2",list.get(position).gift_name)
            i.putExtra("pos3",list.get(position).gift_price)
            i.putExtra("pos4",list.get(position).gift_description)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)

        }


    }

    override fun getItemCount(): Int
    {
        return list.size
    }

}
class MyView2(itemView: View) :RecyclerView.ViewHolder(itemView)
{
    var img1:ImageView = itemView.findViewById(R.id.dashboard_img)
    var txt1:TextView = itemView.findViewById(R.id.txtname)
    var txt2:TextView = itemView.findViewById(R.id.txtprice)
    var txt3:TextView = itemView.findViewById(R.id.txtdes)

}