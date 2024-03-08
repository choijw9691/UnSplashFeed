package com.gemvaxlink.unsplashfeed.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gemvaxlink.unsplashfeed.ui.fragment.CollectionFragment
import com.gemvaxlink.unsplashfeed.ui.fragment.HomeFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2 // 탭의 개수

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> CollectionFragment()
            else -> HomeFragment()
        }
    }
}