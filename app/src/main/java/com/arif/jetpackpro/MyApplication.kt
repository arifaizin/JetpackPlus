package com.arif.jetpackpro

import android.app.Application
import android.content.Context
import com.arif.jetpackpro.di.AppComponent
import com.arif.jetpackpro.di.DaggerAppComponent
import com.google.android.play.core.splitcompat.SplitCompat

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}