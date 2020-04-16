package com.arifaizin.jetpackpro

import android.app.Activity
import android.app.Application
import android.content.Context
import com.arifaizin.core.di.CoreComponent
import com.arifaizin.core.di.DaggerCoreComponent
import com.arifaizin.jetpackpro.di.AppComponent
import com.arifaizin.jetpackpro.di.DaggerAppComponent
import com.google.android.play.core.splitcompat.SplitCompat

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext,
            coreComponent(this)
        )
    }

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as MyApplication).coreComponent
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}

fun Activity.coreComponent() =
    MyApplication.coreComponent(this)
