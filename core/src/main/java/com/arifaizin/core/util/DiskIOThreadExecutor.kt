package com.arifaizin.core.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors


internal class DiskIOThreadExecutor : Executor {
    private val mDiskIO = Executors.newSingleThreadExecutor()

    override fun execute(command: Runnable) {
        mDiskIO.execute(command)
    }
}