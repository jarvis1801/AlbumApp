package com.jarvis.albumlist.base

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext

abstract class BaseRecyclerViewAdapter<BVH: BaseViewHolder>(val context: Context) : RecyclerView.Adapter<BVH>() {
    protected var dataList = arrayListOf<Any>()

    override fun getItemCount(): Int = dataList.size

    suspend fun submitList(newDataList: ArrayList<Any>) {
        if (dataList.isEmpty()) {
            dataList = newDataList
            withContext(Main) { notifyDataSetChanged() }
        } else {
            val diffResult = DiffUtil.calculateDiff(DiffCallback(dataList, newDataList))
            withContext(Main) { diffResult.dispatchUpdatesTo(this@BaseRecyclerViewAdapter) }
            dataList = newDataList
        }
    }
}

class DiffCallback(private val oldDataList: ArrayList<Any>, private val newDataList: ArrayList<Any>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldDataList.size

    override fun getNewListSize(): Int = newDataList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldDataList[oldItemPosition]
        val newItem = newDataList[newItemPosition]

        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldDataList[oldItemPosition]
        val newItem = newDataList[newItemPosition]

        return areItemsTheSame(oldItemPosition, newItemPosition)
    }

}