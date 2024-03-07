package com.gemvaxlink.unsplashfeed.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding

class PhotoViewHolder (
    var binding: ItemPhotoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo){

    }
}