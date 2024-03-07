package com.gemvaxlink.unsplashfeed.data.collection.model

import android.os.Parcelable
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.photo.model.Tag
import com.gemvaxlink.unsplashfeed.data.user.model.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class Collection(
    val id: String,
    val title: String,
    val description: String?,
    val published_at: String?,
    val updated_at: String?,
    val curated: Boolean?,
    val featured: Boolean?,
    val total_photos: Int,
    val private: Boolean?,
    val share_key: String?,
    val tags: List<Tag>?,
    val cover_photo: Photo?,
    val preview_photos: List<Photo>?,
    val user: User?,
    val links: Links?
) : Parcelable

@Parcelize
data class Links(
    val self: String,
    val html: String,
    val photos: String
) : Parcelable
