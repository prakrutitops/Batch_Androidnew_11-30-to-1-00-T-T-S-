package com.example.test

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


@Suppress("DEPRECATION")
class IntroSliderPagerAdapter(fm: FragmentManager, behaviour: Int) : FragmentPagerAdapter(fm, behaviour) {
    // size is HARDCODED!
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return IntroSliderFragment.newInstance(position)
    }

}
