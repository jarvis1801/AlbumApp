package com.jarvis.albumlist.module.main

import android.view.LayoutInflater
import com.jarvis.albumlist.base.BaseActivity
import com.jarvis.albumlist.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun subscribeViewModel() {
    }

    override fun initView() {
    }

    override fun initListener() {

    }

    override fun initStartEvent() {

    }
}