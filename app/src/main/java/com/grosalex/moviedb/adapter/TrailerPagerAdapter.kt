package com.grosalex.moviedb.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.grosalex.moviedb.fragment.TrailerFragment

class TrailerPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    val pages: ArrayList<TrailerFragment> = ArrayList()

    override fun getItem(position: Int): Fragment = pages[position] as Fragment

    override fun getCount(): Int = pages.size
}