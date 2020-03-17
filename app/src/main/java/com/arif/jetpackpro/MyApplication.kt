package com.arif.jetpackpro

import android.app.Application
import android.os.UserManager
import com.arif.jetpackpro.di.AppComponent
import com.arif.jetpackpro.di.DaggerAppComponent

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }
}