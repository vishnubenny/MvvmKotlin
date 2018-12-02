package com.vishnu.mvvmkot1.ui.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class MvvmFragment<T : ViewDataBinding, V : BaseViewModel<N>, N : BaseNavigator> : BaseFragment() {
    private var mViewDataBinding: T? = null
    var mViewModel: V? = null
    var mActivity: MvvmActivity<*, *, *>? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is MvvmActivity<*, *, *>) {
            mActivity = context
            mActivity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = getViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mViewDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        performDataBinding()
    }

    private fun performDataBinding() {
        mViewDataBinding?.apply {
            setVariable(getBindingVariable(), mViewModel)
            executePendingBindings()
        }
    }

    abstract fun getViewModel(): V

    abstract fun getLayoutId(): Int

    abstract fun getBindingVariable(): Int
}