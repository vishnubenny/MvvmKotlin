package com.vishnu.mvvmkot1.application

import com.vishnu.mvvmkot1.ui.util.DebugLogTree
import timber.log.Timber

@Suppress("unused")
class MvvmApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()

        initLogger()
    }

    private fun initLogger() {
        Timber.plant(DebugLogTree())
    }
}