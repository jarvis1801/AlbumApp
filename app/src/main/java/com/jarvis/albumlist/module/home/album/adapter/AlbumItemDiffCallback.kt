package com.jarvis.albumlist.module.home.album.adapter

import androidx.recyclerview.widget.DiffUtil
import com.jarvis.albumlist.model.album.Album

class AlbumItemDiffCallback(private val oldDataList: ArrayList<Album>, private val newDataList: List<Album>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldDataList.size

    override fun getNewListSize(): Int = newDataList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldDataList[oldItemPosition]
        val newItem = newDataList[newItemPosition]

        if (oldItem.collectionId == null || newItem.collectionId == null) {
            return false
        }

        return oldItem.collectionId == newItem.collectionId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTheSame(oldItemPosition, newItemPosition)
    }

}