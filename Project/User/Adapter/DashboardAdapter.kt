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
import com.example.finalproject_batch_1130.Model.DashboardModel
import com.example.finalproject_batch_1130.R
import com.squareup.picasso.Picasso
import retrofit2.Call

class DashboardAdapter(var context: Context,var list:MutableList<DashboardModel>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.dashboard_design,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        Picasso.get().load(list.get(position).url).into(holder.img1)
        holder.itemView.setOnClickListener {

            var i = Intent(context, CategoryActivity::class.java)
            i.putExtra("pos",position)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)


        }
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

}
class MyView(itemView: View) :RecyclerView.ViewHolder(itemView)
{
    var txt1:TextView = itemView.findViewById(R.id.dashboard_txt)
    var img1:ImageView = itemView.findViewById(R.id.dashboard_img)
}