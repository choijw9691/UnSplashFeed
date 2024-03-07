package com.gemvaxlink.unsplashfeed.data.search.model

import com.gemvaxlink.unsplashfeed.data.user.model.User

data class SearchUsersResult(
    val total: Int,
    val total_pages: Int,
    val results: List<User>
)
