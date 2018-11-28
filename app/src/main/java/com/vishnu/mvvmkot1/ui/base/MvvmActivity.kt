package com.vishnu.mvvmkot1.ui.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

abstract class MvvmActivity<T : ViewDataBinding, V : BaseViewModel<N>, N : BaseNavigator> : BaseActivity() {

    private var mViewDataBinding: T? = null
    var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        performDataBinding();
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        if (null == mViewModel) {
            mViewModel = getViewModel()
            mViewModel?.setNavigator(getNavigator());
        }
        mViewDataBinding?.apply {
            setVariable(getBindingVariable(), mViewModel)
            executePendingBindings()
        }
    }

    fun onFragmentAttached() {

    }

    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V?

    abstract fun getBindingVariable(): Int

    abstract fun getNavigator(): N?
}