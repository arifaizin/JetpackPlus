package com.arif.jetpackpro.di

import android.content.Context
import androidx.room.Room
import com.arif.jetpackpro.activity.DetailActivity
import com.arif.jetpackpro.fragment.FavoriteFragment
import com.arif.jetpackpro.fragment.ListMovieFragment
import com.arif.jetpackpro.room.MovieDao
import com.arif.jetpackpro.room.MovieDatabase
import com.arif.jetpackpro.util.AppExecutors
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton




@Singleton  //TODO 4 : Add Dagger Scope - @Singleton
//TODO 2 : Add @Component - Ngasih tau dagger kelas mana saja yg butuh request injection
@Component(modules = [RepositoryModule::class, DatabaseModule::class])
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
@Module(includes = [DatabaseModule::class])
class RepositoryModule {
//    @Singleton
//    @Provides
//    fun provideRepository(context: Context): MovieRepository {
//        val database = MovieDatabase.getInstance(context)
//
//        val localRepository = LocalRepository.getInstance(database.movieDao())
//        val remoteRepository = RemoteRepository.getInstance()
//        val appExecutors = AppExecutors()
//        return MovieRepository.getInstance(localRepository, remoteRepository, appExecutors)
//        return MovieRepository(context)
//    }

//    @Singleton
//    @Provides
//    fun provideRepository(localRepository: LocalRepository, remoteRepository: RemoteRepository, appExecutors: AppExecutors): MovieRepository {
//        return MovieRepository(localRepository, remoteRepository, appExecutors)
//    }

//    @Singleton
//    @Provides
//    fun provideRemote(): RemoteRepository {
//        return RemoteRepository()
//    }

    @Singleton
    @Provides
    fun provideExecutors(): AppExecutors {
        return AppExecutors()
    }
}

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java, "Movie.db"
        )
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao {
        return database.movieDao()
    }

//    @Singleton
//    @Provides
//    fun provideLocal(dao: MovieDao): LocalRepository {
//        return LocalRepository.getInstance(dao)
//    }
}
