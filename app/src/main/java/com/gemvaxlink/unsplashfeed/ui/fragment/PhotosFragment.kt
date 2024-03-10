package com.gemvaxlink.unsplashfeed.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.databinding.FragmentPhotoDetailBinding
import com.gemvaxlink.unsplashfeed.databinding.FragmentPhotosBinding
import com.gemvaxlink.unsplashfeed.ui.activity.MainActivity
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class PhotosFragment(var type: Constants.FragmentType = Constants.FragmentType.MAIN) :
    BaseFragment<FragmentPhotosBinding>(FragmentPhotosBinding::inflate) {

    override fun initialize(binding: FragmentPhotosBinding) {
        super.initialize(binding)

        var photosAdapter = PhotosAdapter(Constants.ListType.PHOTO) { type, id ->
            lifecycleScope.launch {
                // 아이템을 클릭했을때
                viewModel.getPhoto(id)
                when (type) {
                    Constants.ClickType.PROFILE -> {
                    // TODO: 유저 페이지로 연결
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




        when (type) {
            Constants.FragmentType.MAIN -> {

                lifecycleScope.launch {
                    viewModel.mainPhotoList.collectLatest {
                        photosAdapter.submitData(it)
                    }
                }
            }

            Constants.FragmentType.SEARCH -> {

                lifecycleScope.launch {
                    viewModel.searchResultPhotos.collectLatest {
                        photosAdapter.submitData(it)
                    }
                }


            }
        }


    }
}