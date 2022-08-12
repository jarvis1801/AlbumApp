package com.jarvis.albumlist.viewModel

import com.jarvis.albumlist.module.home.album.AlbumRemoteDataSource
import com.jarvis.albumlist.module.home.album.AlbumRepository
import com.jarvis.albumlist.module.home.album.AlbumViewModel
import com.jarvis.albumlist.module.home.bookmark.AlbumBookmarkDataSource
import com.jarvis.albumlist.module.home.bookmark.AlbumBookmarkRepository
import com.jarvis.albumlist.module.home.bookmark.AlbumBookmarkViewModel
import com.jarvis.albumlist.module.main.MainViewModel

object ViewModelBuilder {

    fun buildMainViewModel(): MainViewModel {
        return MainViewModel()
    }

    fun buildAlbumViewModel(): AlbumViewModel {
        val albumRepository = AlbumRepository(AlbumRemoteDataSource())
        return AlbumViewModel(albumRepository)
    }

    fun buildAlbumBookmarkViewModel(): AlbumBookmarkViewModel {
        val albumBookmarkRepository = AlbumBookmarkRepository(AlbumBookmarkDataSource())
        return AlbumBookmarkViewModel(albumBookmarkRepository)
    }
}