package com.jarvis.albumlist.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.jarvis.albumlist.viewModel.ViewModelFactory

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected val mViewBinding: VB by lazy {
        bindingInflater.invoke(layoutInflater)
    }
    abstract val bindingInflater: (LayoutInflater) -> VB

    protected var mViewModel: VM? = null

    protected abstract fun getViewModelClass(): Class<VM>

    abstract fun initView()
    abstract fun initListener()
    abstract fun initStartEvent()
    abstract fun subscribeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(mViewBinding.root)

        val viewModelFactory = ViewModelFactory(this, intent.extras)
        mViewModel = ViewModelProvider(this, viewModelFactory)[getViewModelClass()]
        subscribeViewModel()

        initView()
        initListener()
        initStartEvent()
    }
}