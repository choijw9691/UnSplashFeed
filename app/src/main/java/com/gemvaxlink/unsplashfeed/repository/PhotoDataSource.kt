package com.gemvaxlink.unsplashfeed.repository

import android.util.Log
import androidx.annotation.StringRes
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gemvaxlink.unsplashfeed.R
import com.gemvaxlink.unsplashfeed.data.photo.PhotoService
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo

class PhotoDataSource (
    private val photoService: PhotoService
    ) : PagingSource<Int, Photo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {

        try {

            val currentPage = params.key ?: 1
            val response = photoService.getPhotos(page = currentPage, per_page = 20,order_by = Order.LATEST.value)
            Log.d("JIWOUNG","errorcheck: "+response.size)

            val nextPage = if (response.isEmpty()) null else currentPage + 1
            return LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            Log.d("JIWOUNG","errorcheck: "+e.message)
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition
    }
    companion object {
        enum class Order(@StringRes val titleRes: Int, val value: String) {
            LATEST(R.string.order_latest, "latest"),
            OLDEST(R.string.order_oldest,"oldest"),
            POPULAR(R.string.order_popular, "popular")
        }
    }
}
