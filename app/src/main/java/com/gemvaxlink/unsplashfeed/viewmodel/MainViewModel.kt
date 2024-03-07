package com.gemvaxlink.unsplashfeed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gemvaxlink.unsplashfeed.data.photo.model.Photo
import com.gemvaxlink.unsplashfeed.repository.PhotoRepository
import com.gemvaxlink.unsplashfeed.util.toMutableStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
    /*    private val collectionRepository: CollectionRepository*/
) : ViewModel() {

     val mainPhotoList: Flow<PagingData<Photo>> = photoRepository.getPhotos().cachedIn(viewModelScope)

}
