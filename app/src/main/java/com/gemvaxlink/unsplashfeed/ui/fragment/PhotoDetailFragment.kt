package com.gemvaxlink.unsplashfeed.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.databinding.FragmentCollectionBinding
import com.gemvaxlink.unsplashfeed.databinding.FragmentPhotoDetailBinding
import com.gemvaxlink.unsplashfeed.ui.adapter.ExifAdapter
import com.gemvaxlink.unsplashfeed.ui.adapter.TagAdapter
import com.gemvaxlink.unsplashfeed.util.toPrettyString
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PhotoDetailFragment :
    BaseFragment<FragmentPhotoDetailBinding>(FragmentPhotoDetailBinding::inflate) {

    override fun initialize(binding: FragmentPhotoDetailBinding) {
        super.initialize(binding)



        lifecycleScope.launch {
            viewModel.photo.collectLatest {
                it?.let { it1 -> setPhotoDetailData(it1) }
            }
        }

    }

    fun setPhotoDetailData(photo: Photo) {
        binding.apply {
            Glide.with(requireContext()).load(photo?.urls?.regular).into(binding.photoImageView);

            photo.user?.let { user ->
                userTextView.text = user.name
                userContainer.setOnClickListener {

                }
            }
            photo.location?.let { location ->
                val locationString = when {
                    location.city != null && location.country != null ->
                        getString(R.string.location_template, location.city, location.country)
                    location.city != null && location.country == null -> location.city
                    location.city == null && location.country != null -> location.country
                    else -> null
                }
                locationTextView.text= locationString
            }
            exifRecyclerView.apply {
                layoutManager = GridLayoutManager(context, 2)
                adapter = ExifAdapter(context).apply { setExif(photo) }
            }
            viewsCountTextView.text = (photo.views ?: 0).toPrettyString()
            downloadsCountTextView.text = (photo.downloads ?: 0).toPrettyString()
            likesCountTextView.text = (photo.likes ?: 0).toPrettyString()

            tagRecyclerView.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                adapter = TagAdapter().apply { submitList(photo.tags) }
            }
        }
    }
}