package com.gemvaxlink.unsplashfeed.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.lifecycleScope
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.databinding.FragmentHomeBinding
import com.gemvaxlink.unsplashfeed.databinding.FragmentSearchBinding
import com.gemvaxlink.unsplashfeed.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    override fun initialize(binding: FragmentSearchBinding) {
        super.initialize(binding)
        binding.viewPager.adapter = ViewPagerAdapter(this)

        // 탭 레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            if(position ==0){
                tab.text = "PHOTOS"
            }else if (position ==1){
                tab.text = "COLLECTIONS"
            }else{
                tab.text = "USERS"
            }
        }.attach()

        binding.searchTextInputEditText.setOnEditorActionListener { v, actionId, event ->
            var handled = false

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                // 사용자가 검색 버튼을 눌렀을 때의 처리
                lifecycleScope.launch {
                    viewModel.getSerchResult(v.text.toString())
                }
                handled = true
            }
            handled
        }
    }
}