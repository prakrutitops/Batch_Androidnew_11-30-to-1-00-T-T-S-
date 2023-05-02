package com.example.test

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityCategoryAdapterItemClickBinding

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryAdapterItemClickActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryAdapterItemClickBinding
    private lateinit var apiInterface: ApiInterface
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryAdapterItemClickBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
         var mob=sharedPreferences.getString("mob", "")
        val intent = intent
        val image = intent.getStringExtra("image")
        val giftName = intent.getStringExtra("name")
        val giftDesc = intent.getStringExtra("desc")
        val giftPrice = intent.getStringExtra("price")

        Picasso.get().load(image).into(binding.photoView)
        binding.giftName.text = giftName
        binding.giftDesc.text = giftDesc
        binding.giftPrice.text = giftPrice

        binding.wishListButton.setOnClickListener {
            val call = apiInterface.addDataToWishlist(
                giftName, giftDesc, giftPrice,image,mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to wishlist", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }

        binding.cartButton.setOnClickListener {
            val call = apiInterface.addDataToCart(
                giftName, giftDesc, giftPrice, image,mob)
            call.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext, "Added to Cart", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.wishcartmenu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {

            R.id.i1->
            {
                    startActivity(Intent(applicationContext, WishListActivity::class.java))


            }
            R.id.i2->
            {
                startActivity(Intent(applicationContext, CartActivity::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
    }
}