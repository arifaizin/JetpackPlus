package com.arif.jetpackpro.di

import android.content.Context
import androidx.room.Room
import com.arif.jetpackpro.room.MovieDao
import com.arif.jetpackpro.room.MovieDatabase
import dagger.Module
import dagger.Provides
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton


//TODO 3 : Add @Module - Ngasih tau dagger bagaimana suatu kelas terbentuk
@Module
class DatabaseModule {
    @Singleton // We only want one retrofit instance at any time
    @Provides // Tells Dagger that the Room instance will come from here
    fun provideDatabase(context: Context): MovieDatabase {
        val userEnteredPassphrase = charArrayOf('a', 'r', 'i', 'f')
        val passphrase: ByteArray = SQLiteDatabase.getBytes(userEnteredPassphrase)
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "Movie.db"
        )
            .openHelperFactory(factory)
            .build()
    }

    @Singleton
    @Provides
    //karena MovieDao adalah interface maka harus pakai Provides
    fun provideMovieDao(database: MovieDatabase): MovieDao = database.movieDao()
}