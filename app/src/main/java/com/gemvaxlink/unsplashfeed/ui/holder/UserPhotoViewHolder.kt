package com.gemvaxlink.unsplashfeed.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.photo.model.Tag
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding
import com.gemvaxlink.unsplashfeed.databinding.ItemUserPhotoBinding
import com.gemvaxlink.unsplashfeed.util.Constants
import com.gemvaxlink.unsplashfeed.util.Constants.CROSS_FADE_DURATION

class UserPhotoViewHolder (
    var binding: ItemUserPhotoBinding,
    var onClick: (Constants.ClickType, String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(
        photo: Photo,
    ) {
      val context = binding.photoImageView.context
        with(binding) {
            Glide.with(context)
                .load(photo?.urls?.small)
                .transition(DrawableTransitionOptions.withCrossFade(CROSS_FADE_DURATION))
                .into(binding.photoImageView)
            photoImageView.setOnClickListener {
                onClick(Constants.ClickType.PHOTO,photo.id)
            }
        }
    }
}