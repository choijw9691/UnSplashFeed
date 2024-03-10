package com.gemvaxlink.unsplashfeed.data.search.model

import android.os.Parcelable
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class SearchPhotosResult(
    val total: Int,
    val total_pages: Int,
    val results: List<Photo>
):Parcelable

