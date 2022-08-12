package com.jarvis.albumlist.module.home.bookmark

import com.jarvis.albumlist.base.BaseRepository
import com.jarvis.albumlist.model.album.Album

class AlbumBookmarkRepository(
    private val dataSource: AlbumBookmarkDataSource
) : BaseRepository() {

    suspend fun getJackJohnsonAlbumList(): List<Album> =
        dataSource.getJackJohnsonAlbumList()

}