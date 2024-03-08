package com.gemvaxlink.unsplashfeed.ui.holder

import android.text.SpannableStringBuilder
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoExifBinding
import com.gemvaxlink.unsplashfeed.util.Constants

class ExifViewHolder(
    var binding: ItemPhotoExifBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        titleRes: Int,
        value: SpannableStringBuilder
    ) {
        with(binding) {
            exifTitleTextView.setText(titleRes)
            exifValueTextView.text = value
        }
    }
}