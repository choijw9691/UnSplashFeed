package com.gemvaxlink.unsplashfeed.ui.fragment

import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gemvaxlink.unsplashfeed.databinding.FragmentHomeBinding
import com.gemvaxlink.unsplashfeed.ui.activity.MainActivity
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.ui.adapter.ViewPagerAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initialize(binding: FragmentHomeBinding) {
        super.initialize(binding)
        binding.vpMain.adapter = ViewPagerAdapter(this)

        // 탭 레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout, binding.vpMain) { tab, position ->
            if(position ==1){
                tab.text = "COLLECTIONS"
            }else{
                tab.text = "HOME"
            }
        }.attach()

    binding.searchFloatingButton.setOnClickListener {
        (requireActivity() as MainActivity).replaceFragment(SearchFragment())
    }
    }
}