package com.gemvaxlink.unsplashfeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotoAdapter
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch  {
            viewModel.mainPhotoList.collectLatest {
                PhotosAdapter().submitData(it)

            }
        }
    }
}