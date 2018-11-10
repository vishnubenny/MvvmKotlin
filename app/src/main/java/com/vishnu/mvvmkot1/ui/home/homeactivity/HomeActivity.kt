package com.vishnu.mvvmkot1.ui.home.homeactivity

import android.arch.lifecycle.ViewModelProviders
import com.vishnu.mvvmkot1.BR
import com.vishnu.mvvmkot1.R
import com.vishnu.mvvmkot1.databinding.ActivityHomeBinding
import com.vishnu.mvvmkot1.ui.base.MvvmActivity

class HomeActivity : MvvmActivity<ActivityHomeBinding, HomeActivityViewModel, HomeActivityNavigator>(),
    HomeActivityNavigator {
    override fun getLayoutId() = R.layout.activity_home

    override fun getViewModel() = ViewModelProviders.of(this).get(HomeActivityViewModel::class.java)

    override fun getBindingVariable() = BR.viewModel

    override fun getNavigator() = this
}