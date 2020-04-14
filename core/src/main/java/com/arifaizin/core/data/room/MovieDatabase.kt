package com.arifaizin.core.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel

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