package com.arif.jetpackpro.di

import android.content.Context
import com.arif.jetpackpro.activity.DetailActivity
import com.arif.jetpackpro.activity.MainTabActivity
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.datasource.local.LocalRepository
import com.arif.jetpackpro.datasource.remote.RemoteRepository
import com.arif.jetpackpro.fragment.FavoriteFragment
import com.arif.jetpackpro.fragment.ListMovieFragment
import com.arif.jetpackpro.room.MovieDatabase
import com.arif.jetpackpro.util.AppExecutors
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton  //TODO 4 : Add Dagger Scope - @Singleton
//TODO 2 : Add @Component - Ngasih tau dagger kelas mana saja yg butuh request injection
@Component(modules = [RepositoryModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: DetailActivity)
    fun inject(fragment: ListMovieFragment)
    fun inject(fragment: FavoriteFragment)
}

//TODO 3 : Add @Module - Ngasih tau dagger bagaimana suatu kelas terbentuk
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)

        val localRepository = LocalRepository.getInstance(database.academyDao())
        val remoteRepository = RemoteRepository.getInstance()
        val appExecutors = AppExecutors()
        return MovieRepository.getInstance(localRepository, remoteRepository, appExecutors)
    }
}
