package com.jarvis.albumlist.module.home.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jarvis.albumlist.App
import com.jarvis.albumlist.base.BaseViewModel
import com.jarvis.albumlist.model.album.Album
import com.jarvis.albumlist.model.album.AlbumUpdate
import com.jarvis.albumlist.model.album.AlbumUpdateBookmark
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AlbumViewModel(
    private val albumRepository: AlbumRepository
) : BaseViewModel() {

    private val _albumList = MutableLiveData<List<Album>>()
    val albumList = _albumList as LiveData<List<Album>>

    fun isAlbumListNull(): Boolean = _albumList.value.isNullOrEmpty()

    fun getAlbumList() = viewModelScope.launch(IO) {
        albumRepository.getJackJohnsonAlbumList().genericHandleNetworkRequest()?.let { response ->
            response.albumList?.let { albumList ->
                App.database.albumDao().apply {
                    insertAllIgnore(albumList)
                    updateOrigin(albumList.map { AlbumUpdate(it) })
                    _albumList.postValue(getAll())
                }
            }
        }
    }

    fun updateAlbumBookmark(album: Album, isBookmarked: Boolean) = viewModelScope.launch(IO) {
        App.database.albumDao().updateBookmark(AlbumUpdateBookmark(album, isBookmarked))
    }

}