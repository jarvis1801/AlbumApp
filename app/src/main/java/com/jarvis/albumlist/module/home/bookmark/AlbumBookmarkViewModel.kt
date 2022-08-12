package com.jarvis.albumlist.module.home.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jarvis.albumlist.App
import com.jarvis.albumlist.base.BaseViewModel
import com.jarvis.albumlist.model.album.Album
import com.jarvis.albumlist.model.album.AlbumUpdateBookmark
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AlbumBookmarkViewModel(
    private val albumBookmarkRepository: AlbumBookmarkRepository
) : BaseViewModel() {

    private val _albumList = MutableLiveData<List<Album>>()
    val albumList = _albumList as LiveData<List<Album>>

    fun isAlbumListNull(): Boolean = _albumList.value.isNullOrEmpty()

    fun getAlbumList() = viewModelScope.launch(IO) {
        albumBookmarkRepository.getJackJohnsonAlbumList().let { albumList ->
                _albumList.postValue(albumList)
        }
    }

    fun updateAlbumBookmark(album: Album, isBookmarked: Boolean) = viewModelScope.launch(IO) {
        App.database.albumDao().updateBookmark(AlbumUpdateBookmark(album, isBookmarked))
    }

}