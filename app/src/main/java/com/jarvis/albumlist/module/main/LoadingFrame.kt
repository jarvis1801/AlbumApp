package com.jarvis.albumlist.module.main

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.jarvis.albumlist.databinding.LoadingFrameBinding

class LoadingFrame @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr) {

    private val binding: LoadingFrameBinding by lazy {
        LoadingFrameBinding.inflate(LayoutInflater.from(context), this, true)
    }

    private var isLoading = false

    fun showLoading() {
        if (!isLoading) {
            isLoading = true
            visibility = VISIBLE
        }
    }

    fun hideLoading() {
        if (isLoading) {
            isLoading = false
            visibility = GONE
        }
    }
}