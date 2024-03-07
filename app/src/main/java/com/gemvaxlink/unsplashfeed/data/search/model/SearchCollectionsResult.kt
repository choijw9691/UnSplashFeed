package com.gemvaxlink.unsplashfeed.data.search.model

import com.gemvaxlink.unsplashfeed.data.collection.model.Collection

data class SearchCollectionsResult(
    val total: Int,
    val total_pages: Int,
    val results: List<Collection>
)
