package com.gemvaxlink.unsplashfeed.data.collection.model

import android.os.Parcelable
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import kotlinx.parcelize.Parcelize

@Parcelize
data class CollectionPhotoResult(
    val photo: Photo?,
    val collection: Collection?
) : Parcelable