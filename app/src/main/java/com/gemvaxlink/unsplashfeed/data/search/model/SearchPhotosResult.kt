package com.gemvaxlink.unsplashfeed.data.search.model

import com.gemvaxlink.unsplashfeed.data.photo.model.Photo

data class SearchPhotosResult(
    val total: Int,
    val total_pages: Int,
    val results: List<Photo>
)
