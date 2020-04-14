package com.arifaizin.favorite.dagger

import android.content.Context
import androidx.room.Room
import com.arifaizin.core.data.room.MovieDao
import com.arifaizin.core.data.room.MovieDatabase
import com.arifaizin.core.di.scope.AppScope
import dagger.Module
import dagger.Provides

//TODO 3 : Add @Module - Ngasih tau dagger bagaimana suatu kelas terbentuk
@Module
class DataModule {
    @AppScope
    @Provides // Tells Dagger that the Room instance will come from here
    fun provideDatabase(context: Context): MovieDatabase = Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "Movie.db"
    ).build()

    @AppScope
    @Provides
    //karena MovieDao adalah interface maka harus pakai Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}