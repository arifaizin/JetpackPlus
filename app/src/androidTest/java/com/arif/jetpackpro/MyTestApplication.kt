package com.arif.jetpackpro

import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.datasource.local.LocalRepository
import com.arif.jetpackpro.datasource.remote.RemoteRepository
import com.arif.jetpackpro.room.MovieDatabase
import com.arif.jetpackpro.util.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyTestApplication : MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyTestApplication)
            modules(listOf(viewModelModule, databaseTestModule))
        }
    }
}

val databaseTestModule = module {
    single { get<MovieDatabase>().movieDao()}
    single { LocalRepository(get()) }
    single { RemoteRepository() }
    single { AppExecutors() }
    single { MovieRepository(get(), get(), get()) }
    single (override = true) {
        Room.inMemoryDatabaseBuilder(androidContext(), MovieDatabase::class.java)
            .allowMainThreadQueries()
            .build()    }
}
