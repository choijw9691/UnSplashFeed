package com.gemvaxlink.unsplashfeed.data.photo.model

import android.os.Parcelable
import com.gemvaxlink.unsplashfeed.data.collection.model.Collection
import com.gemvaxlink.unsplashfeed.data.common.model.PhotoStatistics
import com.gemvaxlink.unsplashfeed.data.user.model.User
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Photo(
    val id: String,
    val created_at: String?,
    val updated_at: String?,
    val width: Int?,
    val height: Int?,
    val color: String? = "#E0E0E0",
    val blur_hash: String?,
    val views: Int? = 0,
    val downloads: Int?= 0,
    val likes: Int?,
    var liked_by_user: Boolean?,
    val description: String?,
    val alt_description: String? ="",
    val exif: Exif? = null,
    val location: Location? = null,
    val tags: List<Tag>? = null,
    val current_user_collections: List<Collection>? = null,
    val sponsorship: Sponsorship? = null,
    val urls: Urls,
    val links: Links?,
    val user: User?,
    val statistics: PhotoStatistics? =null
) : Parcelable

@Parcelize
@Serializable
data class Exif(
    val make: String?,
    val model: String?,
    val exposure_time: String?,
    val aperture: String?,
    val focal_length: String?,
    val iso: Int?
) : Parcelable

@Parcelize
@Serializable
data class Location(
    val city: String?,
    val country: String?,
    val position: Position?
) : Parcelable

@Parcelize
@Serializable
data class Position(
    val latitude: Double?,
    val longitude: Double?
) : Parcelable

@Parcelize
@Serializable
data class Tag(
    val type: String?,
    val title: String?
) : Parcelable

@Parcelize
@Serializable
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String
) : Parcelable

@Parcelize
@Serializable
data class Links(
    val self: String,
    val html: String,
    val download: String,
    val download_location: String
) : Parcelable

@Parcelize
@Serializable
data class Sponsorship(
    val sponsor: User?
) : Parcelable