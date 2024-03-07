package com.gemvaxlink.unsplashfeed.ui.base

import android.content.res.Configuration
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BasePagedListAdapter<T : Any, VH: RecyclerView.ViewHolder>(
    diffCallback: DiffUtil.ItemCallback<T>
) : PagingDataAdapter<T, VH>(diffCallback) {

    var orientation = Configuration.ORIENTATION_PORTRAIT
}