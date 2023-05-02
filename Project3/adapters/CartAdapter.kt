package com.example.test.adapters

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.test.*

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartAdapter(var context: Context, var mutableList: MutableList<WishListModel>) :
    RecyclerView.Adapter<ViewHolder2>() {

    lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2
    {
        val view = LayoutInflater.from(context).inflate(R.layout.design_wishlist, parent, false)
        return ViewHolder2(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int)
    {
        sharedPreferences = this.context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
        var myid = mutableList[position].id
        holder.textView1.text = mutableList[position].gift_name
        holder.textView2.text = mutableList[position].gift_price
        holder.textView3.text = mutableList[position].gift_description
        Picasso.get().load(mutableList.get(position).image).into(holder.imageView)

        var mob=sharedPreferences.getString("mob", "")
        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        holder.ib1.setOnClickListener {


            val call = apiInterface.deletecart(myid)
            call!!.enqueue(object :Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {

                    Toast.makeText(it.getContext(), "deleted ", Toast.LENGTH_SHORT).show()
                    val i = Intent(context, CartActivity::class.java)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(i)
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {

                    Toast.makeText(it.getContext(), ""+t.message, Toast.LENGTH_SHORT).show()
                }
            })




        }
        holder.ib2.setOnClickListener {

            val call = apiInterface.addDataToCart(mutableList[position].gift_name, mutableList[position].gift_description, mutableList[position].gift_description, mutableList.get(position).image,mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}

class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var textView1 = itemView.findViewById<TextView>(R.id.category_name_textView)
    var textView2 = itemView.findViewById<TextView>(R.id.category_price_textView)
    var textView3 = itemView.findViewById<TextView>(R.id.category_desc_textView)
    var imageView = itemView.findViewById<ImageView>(R.id.category_imageView)
    var ib1 = itemView.findViewById<ImageButton>(R.id.ib1)
    var ib2 = itemView.findViewById<ImageButton>(R.id.ib2)

}
