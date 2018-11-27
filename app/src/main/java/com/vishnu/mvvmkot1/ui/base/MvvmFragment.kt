package com.vishnu.mvvmkot1.ui.base

import android.databinding.ViewDataBinding

class MvvmFragment<T : ViewDataBinding, V : BaseViewModel<N>, N: BaseNavigator> {
    private var mViewDataBinding: T? = null
    var mViewModel: V? = null


}