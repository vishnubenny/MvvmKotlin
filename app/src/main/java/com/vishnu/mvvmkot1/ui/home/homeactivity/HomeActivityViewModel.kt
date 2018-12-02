package com.vishnu.mvvmkot1.ui.home.homeactivity

import com.vishnu.mvvmkot1.ui.base.BaseViewModel

class HomeActivityViewModel: BaseViewModel<HomeActivityNavigator>() {
    fun getTest() {
        getNavigator()?.showLoader()
    }
}