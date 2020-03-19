package com.arif.jetpackpro

import android.app.Application
import android.content.Context
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.datasource.local.LocalRepository
import com.arif.jetpackpro.datasource.remote.RemoteRepository
import com.arif.jetpackpro.room.MovieDatabase
import com.arif.jetpackpro.util.AppExecutors
import com.arif.jetpackpro.viewmodel.ViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(viewModelModule)
        }
    }
}

val viewModelModule = module {
    single { provideRepository(androidContext()) }
    single { ViewModelFactory(get())}
}

private fun provideRepository(context: Context): MovieRepository {
    val database = MovieDatabase.getInstance(context)

    val localRepository = LocalRepository.getInstance(database.academyDao())
    val remoteRepository = RemoteRepository.getInstance()
    val appExecutors = AppExecutors()
    return MovieRepository.getInstance(localRepository, remoteRepository, appExecutors)
}