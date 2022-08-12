package com.jarvis.albumlist.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jarvis.albumlist.model.album.Album

@Database(entities = [Album::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}