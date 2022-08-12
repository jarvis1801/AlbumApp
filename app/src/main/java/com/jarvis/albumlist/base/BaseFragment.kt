package com.jarvis.albumlist.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewbinding.ViewBinding
import com.jarvis.albumlist.util.ViewExtension.hideStatusBar
import com.jarvis.albumlist.util.ViewExtension.showStatusBar

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected lateinit var mViewBinding: VB
        private set
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    open var isFullScreen = false

    open fun subscribeViewModel() {

    }

    open fun getArgs(): Bundle { return Bundle() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (isFullScreen) hideStatusBar()

        subscribeViewModel()
        mViewBinding = bindingInflater.invoke(inflater, container, false)
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListener()
        initStartEvent()
    }

    abstract fun initView()
    abstract fun initListener()
    abstract fun initStartEvent()

    override fun onDestroy() {
        if (isFullScreen) showStatusBar()
        super.onDestroy()
    }

    fun BaseViewModel.observerErrorMessage() {
        errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            if (!errorMessage.isNullOrBlank()) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}