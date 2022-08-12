package com.jarvis.albumlist.module.home.album

import com.jarvis.albumlist.api.RetrofitClient
import com.jarvis.albumlist.base.BaseDataSource
import com.jarvis.albumlist.model.Resource
import com.jarvis.albumlist.model.album.AlbumListResponse

class AlbumRemoteDataSource : BaseDataSource() {

    suspend fun getJackJohnsonAlbumList(): Resource<AlbumListResponse> {
        return getAlbumList("jack+johnson")
    }

    private suspend fun getAlbumList(term: String) = getResult {
        RetrofitClient.albumApi.getAlbumList(term, "album")
    }
}