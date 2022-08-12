package com.jarvis.albumlist.viewModel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.jarvis.albumlist.module.home.album.AlbumViewModel
import com.jarvis.albumlist.module.home.bookmark.AlbumBookmarkViewModel
import com.jarvis.albumlist.module.main.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(owner: SavedStateRegistryOwner, defaultArgs: Bundle? = Bundle()) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return with(modelClass) {

            when {
                isAssignableFrom(MainViewModel::class.java) -> ViewModelBuilder.buildMainViewModel()
                isAssignableFrom(AlbumViewModel::class.java) -> ViewModelBuilder.buildAlbumViewModel()
                isAssignableFrom(AlbumBookmarkViewModel::class.java) -> ViewModelBuilder.buildAlbumBookmarkViewModel()

                else ->
                    throw IllegalArgumentException(
                        "Unknown ViewModel class: ${modelClass.name}"
                    )
            }

        } as T
    }

}

