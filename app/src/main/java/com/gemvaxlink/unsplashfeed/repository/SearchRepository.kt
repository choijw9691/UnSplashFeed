package com.gemvaxlink.unsplashfeed.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gemvaxlink.unsplashfeed.data.photo.PhotoService
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.search.SearchService
import com.gemvaxlink.unsplashfeed.data.search.model.SearchPhotosResult
import com.gemvaxlink.unsplashfeed.data.user.UserService
import com.gemvaxlink.unsplashfeed.data.user.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val photoService: PhotoService,
    private val searchService: SearchService
) {

     fun getPhotos(query: String): Flow<PagingData<Photo>> {

        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { SearchPhotoDataSource(photoService,searchService,query) }
        ).flow
    }

}
