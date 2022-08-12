package com.jarvis.albumlist.api.service

import com.jarvis.albumlist.model.album.AlbumListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("search")
    suspend fun getAlbumList(@Query("term") term: String, @Query("entity") entity: String) : Response<AlbumListResponse>
}