package com.gemvaxlink.unsplashfeed.ui.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.ui.base.BasePagedListAdapter

class PhotosAdapter : BasePagedListAdapter<Photo, RecyclerView.ViewHolder>(PHOTO_COMPARATOR) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        // 레이아웃 인플레이팅과 ViewHolder 생성 로직 구현
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        // 데이터 바인딩 로직 구현
    }

    class PhotoViewHolder(/* 뷰 홀더 인자 */) : RecyclerView.ViewHolder(/* 뷰 홀더 레이아웃 */) {
        // 뷰 바인딩 로직 구현
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                // 아이템 동일성 비교 로직 구현
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                // 아이템 내용 비교 로직 구현
            }
        }
    }
}