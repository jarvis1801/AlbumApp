package com.jarvis.albumlist.module.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jarvis.albumlist.module.home.album.AlbumListFragment
import com.jarvis.albumlist.module.home.bookmark.AlbumBookmarkListFragment

class HomeSectionAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    private var fragmentList: ArrayList<Fragment> = arrayListOf(
        AlbumListFragment(),
        AlbumBookmarkListFragment()
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}