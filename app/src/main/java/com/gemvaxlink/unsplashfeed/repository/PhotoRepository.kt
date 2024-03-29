package com.gemvaxlink.unsplashfeed.repository


import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gemvaxlink.unsplashfeed.data.collection.CollectionService
import com.gemvaxlink.unsplashfeed.data.photo.PhotoService
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.search.SearchService
import com.gemvaxlink.unsplashfeed.data.user.UserService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photoService: PhotoService,
    private val searchService: SearchService
) {
    fun getPhotos(): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { PhotoDataSource(photoService,searchService) }
        ).flow
    }

    suspend fun getPhoto(id: String): Photo {
        return photoService.getPhoto(id)
    }
}
