package com.example.finalproject_batch_1130.Activity


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.finalproject_batch_1130.Adapter.SliderPagerAdapter
import com.example.finalproject_batch_1130.R
import com.google.android.material.tabs.TabLayout


class SliderActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    private var button: Button? = null
    private var adapter: SliderPagerAdapter? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // making activity full screen
        if (Build.VERSION.SDK_INT >= 21) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        setContentView(R.layout.activity_slider)
        // hide action bar you can use NoAction theme as well
        supportActionBar!!.hide()
        // bind views
        viewPager = findViewById<ViewPager>(R.id.pagerIntroSlider)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        button = findViewById<Button>(R.id.button)
        // init slider pager adapter
        adapter = SliderPagerAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        // set adapter
        viewPager!!.setAdapter(adapter)
        // set dot indicators
        tabLayout.setupWithViewPager(viewPager)
        // make status bar transparent
        changeStatusBarColor()
        button!!.setOnClickListener(View.OnClickListener {
            if (viewPager!!.getCurrentItem() < adapter!!.count) {
                viewPager!!.setCurrentItem(viewPager!!.getCurrentItem() + 1)
            }
        })
        /**
         * Add a listener that will be invoked whenever the page changes
         * or is incrementally scrolled
         */
        viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position == adapter!!.count - 1) {
                    button!!.setText(R.string.get_started)
                } else {
                    button!!.setText(R.string.next)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}