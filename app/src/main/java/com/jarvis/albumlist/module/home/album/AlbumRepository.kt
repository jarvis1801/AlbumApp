package com.jarvis.albumlist.module.home.album

import com.jarvis.albumlist.base.BaseRepository
import com.jarvis.albumlist.model.Resource
import com.jarvis.albumlist.model.album.AlbumListResponse

class AlbumRepository(
    private val dataSource: AlbumRemoteDataSource,
//    private val dataSource: AlbumDummyDataSource,
) : BaseRepository(), AlbumRepositoryInterface {

    override suspend fun getJackJohnsonAlbumList(): Resource<AlbumListResponse> =
        dataSource.getJackJohnsonAlbumList()


}