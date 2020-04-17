package com.arifaizin.core.utils

import com.arifaizin.core.util.AppExecutors
import java.util.concurrent.Executor


class InstantAppExecutors : AppExecutors(instant, instant, instant) {
    companion object {
        private val instant = Executor { it.run() }
    }
}