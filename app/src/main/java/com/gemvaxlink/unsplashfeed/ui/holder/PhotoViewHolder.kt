package com.gemvaxlink.unsplashfeed.ui.holder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding
import com.gemvaxlink.unsplashfeed.util.Constants

class PhotoViewHolder(
    var binding: ItemPhotoBinding,
    var onClick: (Constants.ClickType,String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    val CROSS_FADE_DURATION = 350

    fun bind(photo: Photo) {
        var context = binding.ivPhoto.context
        binding.tvName.text = photo.user?.name
        Glide.with(context).load(photo.user?.profile_image?.medium).into(binding.ivProfile);


        binding.ivPhoto?.apply { background = ColorDrawable(Color.parseColor(photo.color)) }
        Glide.with(context)
            .load(photo.urls.regular)
            .thumbnail(
                Glide.with(context).load(photo.urls.thumb)
            )
            .transition(DrawableTransitionOptions.withCrossFade(CROSS_FADE_DURATION))
            .into(binding.ivPhoto)
        //.clearOnDetach()

        binding.ivPhoto.setOnClickListener {
            onClick(Constants.ClickType.PHOTO,photo.id)
        }
        binding.lyTop.setOnClickListener {
            onClick(Constants.ClickType.PROFILE,photo.id)
        }
    }
}