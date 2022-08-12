package com.jarvis.albumlist.module.home.album.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.jarvis.albumlist.base.BaseRecyclerViewAdapter
import com.jarvis.albumlist.base.BaseViewHolder
import com.jarvis.albumlist.databinding.ItemAlbumBinding
import com.jarvis.albumlist.model.album.Album

class AlbumAdapter(context: Context, var onBookmarkClick: (album: Album, isBookmarked: Boolean) -> Unit) : BaseRecyclerViewAdapter<AlbumAdapter.ViewHolder, Album>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemAlbumBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], position)
    }

    override fun getItemDiffCallback(dataList: ArrayList<Album>, newDataList: List<Album>): DiffUtil.Callback {
        return AlbumItemDiffCallback(dataList, newDataList)
    }

    inner class ViewHolder(private val binding: ItemAlbumBinding) : BaseViewHolder(binding.root) {
        override fun bind(item: Any, position: Int) {
            val currentItem = item as Album

            currentItem.apply {
                binding.tvCollectionName.text = currentItem.collectionName

                binding.ivThumbnail.apply {
                    Glide.with(this)
                        .load(currentItem.artworkUrl100)
                        .centerCrop()
                        .into(this)

                }

                binding.ivBookmark.apply {
                    this.isSelected = currentItem.isBookmarked == true
                    setOnClickListener {
                        val isBookmarked = !it.isSelected
                        it.isSelected = isBookmarked
                        onBookmarkClick(currentItem, isBookmarked)
                    }
                }
            }
        }
    }
}