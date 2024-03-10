package com.gemvaxlink.unsplashfeed.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gemvaxlink.unsplashfeed.ui.fragment.CollectionFragment
import com.gemvaxlink.unsplashfeed.ui.fragment.HomeFragment
import com.gemvaxlink.unsplashfeed.ui.fragment.PhotosFragment
import com.gemvaxlink.unsplashfeed.ui.fragment.SearchFragment
import com.gemvaxlink.unsplashfeed.ui.fragment.UserFragment
import com.gemvaxlink.unsplashfeed.util.Constants

class ViewPagerAdapter(var fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = if (fragment is SearchFragment) 3 else 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> if (fragment is SearchFragment) PhotosFragment(Constants.FragmentType.SEARCH) else PhotosFragment()
            1 -> CollectionFragment()
            2 -> UserFragment()
            else -> PhotosFragment()
        }
    }
}