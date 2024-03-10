package com.gemvaxlink.unsplashfeed.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.user.UserService
import com.gemvaxlink.unsplashfeed.data.user.model.User
import com.gemvaxlink.unsplashfeed.util.Constants

class UserDataSource(
    private val userService: UserService,
    private val user: User
) : PagingSource<Int, Photo>() {
    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, Photo> {

        try {

            val currentPage = params.key ?: 1
            val response = userService.getUserPhotos(
                username = user.username.toString(),
                null,
                null,
                null,
                null,
                null,
                null,
                null
            )
            Log.d("JIWOUNG", "sizecheck123: " + response.size)

            val nextPage = if (response.isEmpty()) null else currentPage + 1
            return PagingSource.LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            Log.d("JIWOUNG", "errorcheck: " + e.message)
            return PagingSource.LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }
}