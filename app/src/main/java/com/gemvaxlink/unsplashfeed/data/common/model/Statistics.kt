package com.gemvaxlink.unsplashfeed.data.common.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class PhotoStatistics(
    val id: String,
    val downloads: Downloads,
    val views: Views,
    val likes: Likes
) : Parcelable

data class UserStatistics(
    val username: String,
    val downloads: Downloads,
    val views: Views,
    val likes: Likes
)

@Parcelize
@Serializable
data class Downloads(
    val total: Int,
    val historical: Historical
) : Parcelable

@Parcelize
@Serializable
data class Views(
    val total: Int,
    val historical: Historical
) : Parcelable

@Parcelize
@Serializable
data class Likes(
    val total: Int,
    val historical: Historical
) : Parcelable

@Parcelize
@Serializable
data class Historical(
    val change: Int,
    val resolution: String,
    val quality: String,
    val values: List<Value>
) : Parcelable

@Parcelize
@Serializable
data class Value(
    val date: String,
    val value: Int
) : Parcelable
