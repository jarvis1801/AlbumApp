package com.jarvis.albumlist.module.home.album

import com.jarvis.albumlist.App
import com.jarvis.albumlist.base.BaseDataSource
import com.jarvis.albumlist.model.Resource
import com.jarvis.albumlist.model.album.AlbumListResponse
import com.jarvis.albumlist.util.GsonUtil.stringToObject

class AlbumDummyDataSource : BaseDataSource(), AlbumRepositoryInterface {

    companion object {
        private const val FILE_PATH = "album/dummyData.json"
    }

    override suspend fun getJackJohnsonAlbumList(): Resource<AlbumListResponse> {
        val body = App.instance.getStringFromAsset(FILE_PATH)!!.stringToObject<AlbumListResponse>()
        return Resource.success(body, 200)
    }


}