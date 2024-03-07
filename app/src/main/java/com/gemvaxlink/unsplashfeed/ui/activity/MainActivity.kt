package com.gemvaxlink.unsplashfeed.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import com.gemvaxlink.unsplashfeed.viewmodel.MainViewModel
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter = PhotosAdapter(Constants.ListType.PHOTO)
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this) // LinearLayoutManager 또는 원하는 레이아웃 매니저 설정

        lifecycleScope.launch  {
            viewModel.mainPhotoList.collectLatest {
                Log.d("JIWOUNG","fkwelnmsrl4ml4m")
                    adapter.submitData(it)
            }
        }
    }
}