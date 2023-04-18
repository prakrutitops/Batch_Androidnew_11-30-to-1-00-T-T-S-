package com.example.finalproject_batch_1130.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.finalproject_batch_1130.Fragment.SliderFragment


class SliderPagerAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior)
{
    override fun getItem(position: Int): Fragment
    {
        return SliderFragment.newInstance(position)
    }

    // size is hardcoded
    override fun getCount(): Int
    {
        return 4
    }
}