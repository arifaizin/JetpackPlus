package com.arif.jetpackpro

import android.content.Context
import androidx.multidex.MultiDexApplication
import androidx.room.Room
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.datasource.local.LocalRepository
import com.arif.jetpackpro.datasource.remote.RemoteRepository
import com.arif.jetpackpro.room.MovieDatabase
import com.arif.jetpackpro.util.AppExecutors
import com.arif.jetpackpro.viewmodel.DetailMovieViewModel
import com.arif.jetpackpro.viewmodel.FavoriteViewModel
import com.arif.jetpackpro.viewmodel.MovieViewModel
import com.arif.jetpackpro.viewmodel.ViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(viewModelModule, databaseModule))
        }
    }
}

val viewModelModule = module {
    single { ViewModelFactory(get())}
    viewModel { MovieViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}

val databaseModule = module {
    single { get<MovieDatabase>().movieDao()}
    single { LocalRepository(get()) }
    single { RemoteRepository() }
    single { AppExecutors() }
    single { MovieRepository(get(), get(), get()) }
    single { provideDatabase(androidContext()) }
}

fun provideDatabase(context: Context): MovieDatabase = Room.databaseBuilder(
    context,
    MovieDatabase::class.java, "Movie.db"
).build()

val databaseTestModule = module {
    single {
        Room.inMemoryDatabaseBuilder(androidContext(), MovieDatabase::class.java)
            .allowMainThreadQueries()
            .build()    }
}
