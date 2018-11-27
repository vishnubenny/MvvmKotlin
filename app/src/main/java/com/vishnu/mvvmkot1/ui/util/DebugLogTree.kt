package com.vishnu.mvvmkot1.ui.util

import android.os.Build
import android.util.Log
import timber.log.Timber


class DebugLogTree : Timber.DebugTree() {

    override fun log(priorityArg: Int, tag: String?, message: String, t: Throwable?) {
        var priority = priorityArg
        // Workaround for devices that doesn't show lower priority logs
        if (Build.MANUFACTURER == "HUAWEI" || Build.MANUFACTURER == "samsung") {
            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO)
                priority = Log.ERROR
        }
        super.log(priority, tag, message, t)
    }

    override fun createStackElementTag(element: StackTraceElement): String? {
        // Add log statements line number to the log
        return super.createStackElementTag(element) + " - " + element.lineNumber
    }
}