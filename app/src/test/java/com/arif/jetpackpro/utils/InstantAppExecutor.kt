package com.arif.jetpackpro.utils

import com.arif.jetpackpro.util.AppExecutors
import java.util.concurrent.Executor


class InstantAppExecutors : AppExecutors(instant, instant) {
    companion object {
        private val instant = Executor { it.run() }
    }
}