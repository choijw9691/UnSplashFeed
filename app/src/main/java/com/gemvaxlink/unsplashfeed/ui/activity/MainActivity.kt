package com.gemvaxlink.unsplashfeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment

import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.databinding.ActivityMainBinding
import com.gemvaxlink.unsplashfeed.ui.fragment.HomeFragment
import com.gemvaxlink.unsplashfeed.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment) // 'fragment_container'는 교체될 프래그먼트가 들어갈 레이아웃의 ID입니다.
        transaction.addToBackStack(null) // 필요하다면 백스택에 추가
        transaction.commit()
    }
}