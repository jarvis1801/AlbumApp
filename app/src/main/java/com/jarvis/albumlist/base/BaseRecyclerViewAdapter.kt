package com.jarvis.albumlist.base

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jarvis.albumlist.model.album.Album
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext

abstract class BaseRecyclerViewAdapter<BVH: BaseViewHolder, T>(val context: Context) : RecyclerView.Adapter<BVH>() {
    protected var dataList = arrayListOf<T>()

    override fun getItemCount(): Int = dataList.size

    abstract fun getItemDiffCallback(dataList: ArrayList<T>, newDataList: List<T>): DiffUtil.Callback

    suspend fun submitList(newDataList: List<T>) {
        if (dataList.isEmpty()) {
            dataList = newDataList.toCollection(ArrayList())
            withContext(Main) { notifyDataSetChanged() }
        } else {
            val diffResult = DiffUtil.calculateDiff(getItemDiffCallback(dataList, newDataList))
            withContext(Main) { diffResult.dispatchUpdatesTo(this@BaseRecyclerViewAdapter) }
            dataList = newDataList.toCollection(ArrayList())
        }
    }
}