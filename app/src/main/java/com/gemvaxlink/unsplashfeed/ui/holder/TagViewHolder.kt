package com.gemvaxlink.unsplashfeed.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.data.photo.model.Tag
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoTagBinding

class TagViewHolder(
    var binding: ItemPhotoTagBinding,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(
        tag: Tag?,
    ) {
        with(binding) {
            tag?.title?.let { title ->
                tagChip.text = title
            }
        }
    }
}