package com.gemvaxlink.unsplashfeed.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.databinding.ItemPhotoBinding
import com.gemvaxlink.unsplashfeed.ui.base.BasePagedListAdapter
import com.gemvaxlink.unsplashfeed.ui.holder.PhotoViewHolder
import com.gemvaxlink.unsplashfeed.util.Constants

class PhotosAdapter(var listType: Constants.ListType) : BasePagedListAdapter<Photo, RecyclerView.ViewHolder>(PHOTO_COMPARATOR) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("PhotosAdapter", "Photo at position ")

        when(listType){
            Constants.ListType.PHOTO->{
                getItem(position)?.let { (holder as PhotoViewHolder).bind(it)

                }
            }
            else->{
                throw IllegalArgumentException("Invalid view type")
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        Log.d("PhotosAdapter", "Photo at position1 ")

        when(listType){
            Constants.ListType.PHOTO->{
                val binding =
                    ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
               return PhotoViewHolder(binding)
            }else->{
            throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {

                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }
        }
    }
}