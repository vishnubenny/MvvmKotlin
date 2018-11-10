package com.vishnu.mvvmkot1.ui.base

import android.arch.lifecycle.ViewModel

open class BaseViewModel<N : BaseNavigator> : ViewModel() {
    var mNavigator: N? = null

    fun setNavigator(navigator: N?) {
        mNavigator = navigator
    }

    fun getNavigator() = mNavigator
}