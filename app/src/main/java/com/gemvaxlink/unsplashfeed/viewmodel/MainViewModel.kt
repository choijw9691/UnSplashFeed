package com.gemvaxlink.unsplashfeed.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gemvaxlink.unsplashfeed.data.collection.model.Collection
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.data.user.model.User
import com.gemvaxlink.unsplashfeed.repository.PhotoRepository
import com.gemvaxlink.unsplashfeed.repository.SearchRepository
import com.gemvaxlink.unsplashfeed.repository.UserRepository
import com.gemvaxlink.unsplashfeed.util.toMutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val userRepository: UserRepository,
    private val searchRepository: SearchRepository
) : ViewModel() {

    val mainPhotoList: Flow<PagingData<Photo>> =
        photoRepository.getPhotos().cachedIn(viewModelScope)
    private val _photo = MutableStateFlow<Photo?>(null)
    val photo: StateFlow<Photo?> = _photo
    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user
    var userPhotos: Flow<PagingData<Photo>>? = null
    var searchResultPhotos: Flow<PagingData<Photo>> = emptyFlow()
    var searchResultCollections: Flow<PagingData<Collection>>? = null
    var searchResultUsers: Flow<PagingData<User>>? = null

    suspend fun getPhoto(id: String) {
        _photo.value = photoRepository.getPhoto(id)
    }

    suspend fun getUser(id: String) {
        _user.value = userRepository.getUser(id)
    }

    fun getUserPhotos(user: User) {
      userPhotos = userRepository.getUserPhotos(user).cachedIn(viewModelScope)
    }
     fun getSerchResult(query : String){
        searchResultPhotos = searchRepository.getPhotos(query).cachedIn(viewModelScope)
    }
}
