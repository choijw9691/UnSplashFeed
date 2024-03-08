package com.gemvaxlink.unsplashfeed.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.data.photo.model.Tag
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoTagBinding
import com.gemvaxlink.unsplashfeed.ui.holder.TagViewHolder

class TagAdapter() : ListAdapter<Tag, TagViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val binding =
            ItemPhotoTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<Tag>() {
            override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = oldItem.title == newItem.title
            override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = oldItem == newItem
        }
    }
}