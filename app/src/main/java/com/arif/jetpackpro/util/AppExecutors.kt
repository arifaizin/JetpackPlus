package com.arif.jetpackpro.util

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import javax.inject.Singleton

open class AppExecutors @VisibleForTesting
constructor(private val diskIO: Executor, private val mainThread: Executor) {

    constructor() : this(
        DiskIOThreadExecutor(), MainThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

    fun mainThread(): Executor = mainThread

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}