package com.arif.jetpackpro.di

import android.content.Context
import androidx.room.Room
import com.arifaizin.core.room.MovieDao
import com.arifaizin.core.room.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//TODO 3 : Add @Module - Ngasih tau dagger bagaimana suatu kelas terbentuk
@Module
class DatabaseModule {
    @Singleton // We only want one retrofit instance at any time
    @Provides // Tells Dagger that the Room instance will come from here
    fun provideDatabase(context: Context): MovieDatabase = Room.databaseBuilder(
        context,
        MovieDatabase::class.java, "Movie.db"
    ).build()

    @Singleton
    @Provides
    //karena MovieDao adalah interface maka harus pakai Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}