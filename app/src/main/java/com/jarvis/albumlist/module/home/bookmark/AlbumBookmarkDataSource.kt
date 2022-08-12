package com.jarvis.albumlist.module.home.bookmark

import com.jarvis.albumlist.App
import com.jarvis.albumlist.api.RetrofitClient
import com.jarvis.albumlist.base.BaseDataSource
import com.jarvis.albumlist.model.Resource
import com.jarvis.albumlist.model.album.Album
import com.jarvis.albumlist.model.album.AlbumListResponse

class AlbumBookmarkDataSource : BaseDataSource() {

    fun getJackJohnsonAlbumList(): List<Album> {
        return App.database.albumDao().getAll().filter { it.isBookmarked == true }
    }

}