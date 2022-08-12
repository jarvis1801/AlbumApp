package com.jarvis.albumlist.dao

import androidx.room.*
import com.jarvis.albumlist.model.album.Album
import com.jarvis.albumlist.model.album.AlbumUpdate
import com.jarvis.albumlist.model.album.AlbumUpdateBookmark

@Dao
interface AlbumDao {
    @Query("SELECT * FROM album")
    fun getAll(): List<Album>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllIgnore(album: List<Album>)

    @Update(entity = Album::class)
    fun updateOrigin(album: AlbumUpdate)

    @Update(entity = Album::class)
    fun updateOrigin(album: List<AlbumUpdate>)

    @Update(entity = Album::class)
    fun updateBookmark(album: AlbumUpdateBookmark)

    @Delete
    fun delete(album: Album)
}