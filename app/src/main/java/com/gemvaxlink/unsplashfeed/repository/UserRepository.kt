package com.gemvaxlink.unsplashfeed.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gemvaxlink.unsplashfeed.data.photo.PhotoService
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.user.UserService
import com.gemvaxlink.unsplashfeed.data.user.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository  @Inject constructor(
    private val userService: UserService
) {

    suspend fun getUser(id: String): User {
        return userService.getUserPublicProfile(id)
    }

    fun getUserPhotos(user:User): Flow<PagingData<Photo>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { UserDataSource(userService,user) }
        ).flow
    }
}
