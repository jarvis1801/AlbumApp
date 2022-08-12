package com.jarvis.albumlist.module.home.bookmark

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.jarvis.albumlist.base.BaseFragment
import com.jarvis.albumlist.databinding.FragmentAlbumListBinding
import com.jarvis.albumlist.module.home.album.AlbumViewModel
import com.jarvis.albumlist.module.home.album.adapter.AlbumAdapter
import com.jarvis.albumlist.viewModel.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumBookmarkListFragment : BaseFragment<FragmentAlbumListBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAlbumListBinding
        get() = FragmentAlbumListBinding::inflate

    private val viewModel: AlbumBookmarkViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory(this, arguments))[AlbumBookmarkViewModel::class.java]
    }

    private lateinit var listAdapter: AlbumAdapter

    override fun subscribeViewModel() {
        super.subscribeViewModel()

        viewModel.observerErrorMessage()

        viewModel.albumList.observe(viewLifecycleOwner) { albumList ->
            if (!albumList.isNullOrEmpty()) {
                lifecycleScope.launch(Dispatchers.Main) {
                    listAdapter.submitList(albumList)
                }
            }
        }
    }

    override fun initView() {
        listAdapter = AlbumAdapter(requireContext()) { album, isBookmarked ->
            viewModel.updateAlbumBookmark(album, isBookmarked)
        }
        mViewBinding.rvAlbum.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            (itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
            adapter = listAdapter
        }
    }

    override fun initListener() { }

    override fun initStartEvent() { }

    override fun onResume() {
        super.onResume()
        viewModel.getAlbumList()
    }

    override fun onPause() {
        super.onPause()
    }

}