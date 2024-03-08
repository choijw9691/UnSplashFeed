package com.gemvaxlink.unsplashfeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.databinding.ActivityMainBinding
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.ui.adapter.ViewPagerAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import com.gemvaxlink.unsplashfeed.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpMain.adapter = ViewPagerAdapter(this)

        // 탭 레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout, binding.vpMain) { tab, position ->
            if(position ==1){
                tab.text = "COLLECTIONS"
            }else{
                tab.text = "HOME"
            }
        }.attach()

    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment) // 'fragment_container'는 교체될 프래그먼트가 들어갈 레이아웃의 ID입니다.
        transaction.addToBackStack(null) // 필요하다면 백스택에 추가
        transaction.commit()
    }
}