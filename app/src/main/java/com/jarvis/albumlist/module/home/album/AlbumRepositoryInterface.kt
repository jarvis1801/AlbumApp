package com.jarvis.albumlist.module.home.album

import com.jarvis.albumlist.model.Resource
import com.jarvis.albumlist.model.album.AlbumListResponse

interface AlbumRepositoryInterface {

    suspend fun getJackJohnsonAlbumList(): Resource<AlbumListResponse>
}