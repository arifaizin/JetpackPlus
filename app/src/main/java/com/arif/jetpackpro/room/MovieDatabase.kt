package com.arif.jetpackpro.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arifaizin.core.model.movie.MovieModel
import com.arifaizin.core.model.tvshow.TvShowModel

@Database(entities = [MovieModel::class, TvShowModel::class],
    version = 1,
    exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

//    companion object {
//        private var INSTANCE: MovieDatabase? = null
//        private val sLock = Any()
//
//        fun getInstance(context: Context): MovieDatabase {
//            synchronized(sLock) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        MovieDatabase::class.java, "Movie.db"
//                    )
//                        .build()
//                }
//                return INSTANCE as MovieDatabase
//            }
//        }
//    }
}