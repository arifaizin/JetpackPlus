package com.arif.jetpackpro.di

import android.content.Context
import androidx.room.Room
import com.arifaizin.core.data.room.MovieDao
import com.arifaizin.core.data.room.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase = Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "Movie.db"
    ).build()

    @Singleton
    @Provides
    //karena MovieDao adalah interface maka harus pakai Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}