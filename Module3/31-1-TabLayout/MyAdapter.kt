package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyAdapter(fm:FragmentManager) :FragmentStatePagerAdapter(fm)
{
    var ListTitle:MutableList<String> = ArrayList()
    var ListFragment:MutableList<Fragment> = ArrayList()


    override fun getCount(): Int
    {
        return  ListFragment.size
    }

    override fun getItem(position: Int): Fragment
    {
        return  ListFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return  ListTitle.get(position)
    }

    fun adddata(fragment: Fragment,title:String)
    {
        ListTitle.add(title)
        ListFragment.add(fragment)
    }


}