package com.gemvaxlink.unsplashfeed.data.authorization.model


data class AccessToken(
    val access_token: String,
    val token_type: String?,
    val scope: String?,
    val create_at: Int?
)
