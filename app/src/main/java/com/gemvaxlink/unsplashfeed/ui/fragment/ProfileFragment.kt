package com.gemvaxlink.unsplashfeed.ui.fragment

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gemvaxlink.unsplashfeed.data.user.model.User
import com.gemvaxlink.unsplashfeed.databinding.FragmentProfileBinding
import com.gemvaxlink.unsplashfeed.ui.activity.MainActivity
import com.gemvaxlink.unsplashfeed.ui.adapter.PhotosAdapter
import com.gemvaxlink.unsplashfeed.ui.adapter.UserPhotosAdapter
import com.gemvaxlink.unsplashfeed.util.Constants
import com.gemvaxlink.unsplashfeed.util.toPrettyString
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ProfileFragment(var user:User) :
    BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    lateinit var photosAdapter: PhotosAdapter

    override fun initialize(binding: FragmentProfileBinding) {
        super.initialize(binding)
        setUserData()
        initRecyclerView()
    }
    fun setUserData(){
        binding.apply {
            nameTextView.text = user.name
            photosCountTextView.text = user.total_photos?.toPrettyString()
            likesCountTextView.text = user.total_likes?.toPrettyString()
            collectionsCountTextView.text = user.total_collections?.toPrettyString()
            locationTextView.text = user.location
            bioTextView.text = user.bio?.trimEnd()
            Glide.with(requireContext()).load(user.profile_image?.large).into(binding.userImageView);
        }
    }
    fun initFlowData(){
        lifecycleScope.launch {
            viewModel.userPhotos?.collectLatest {
                photosAdapter.submitData(it)
            }
        }
    }
    fun initRecyclerView(){
         photosAdapter = PhotosAdapter(Constants.ListType.USER_PHOTOS) {
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
        binding.userPhotosRv.apply {
            val gridLayoutManager = GridLayoutManager(requireContext(), 2)
            layoutManager = gridLayoutManager
            adapter = photosAdapter
        }
        initFlowData()
    }
}