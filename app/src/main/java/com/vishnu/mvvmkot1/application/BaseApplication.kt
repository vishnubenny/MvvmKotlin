package com.vishnu.mvvmkot1.application

import android.app.Application
import com.vishnu.mvvmkot1.ui.util.DebugLogTree
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(DebugLogTree())
    }
}