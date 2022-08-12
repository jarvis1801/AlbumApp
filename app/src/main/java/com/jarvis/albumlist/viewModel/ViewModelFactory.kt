package com.jarvis.albumlist.viewModel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(owner: SavedStateRegistryOwner, defaultArgs: Bundle? = Bundle()) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return with(modelClass) {

            when {

                // TODO

                else ->
                    throw IllegalArgumentException(
                        "Unknown ViewModel class: ${modelClass.name}"
                    )
            }

        } as T
    }

}

