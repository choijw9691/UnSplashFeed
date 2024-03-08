package com.gemvaxlink.unsplashfeed.ui.fragment

import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gemvaxlink.unsplashfeed.databinding.FragmentHomeBinding
import com.gemvaxlink.unsplashfeed.ui.activity.MainActivity
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun initialize(binding: FragmentHomeBinding) {
        super.initialize(binding)
        var photosAdapter = PhotosAdapter(Constants.ListType.PHOTO) {
            type,id ->
            lifecycleScope.launch {
                // 아이템을 클릭했을때
                viewModel.getPhoto(id)
                when (type) {
                    Constants.ClickType.PROFILE -> {

                    }

                    Constants.ClickType.PHOTO -> {
                        (requireActivity() as MainActivity).replaceFragment(PhotoDetailFragment())
                    }
                }
            }

        }
        binding.rvMain.apply {
            adapter = photosAdapter
            layoutManager =
                LinearLayoutManager(requireContext()) // LinearLayoutManager 또는 원하는 레이아웃 매니저 설정
        }

        lifecycleScope.launch {
            viewModel.mainPhotoList.collectLatest {
                photosAdapter.submitData(it)
            }
        }
    }
}