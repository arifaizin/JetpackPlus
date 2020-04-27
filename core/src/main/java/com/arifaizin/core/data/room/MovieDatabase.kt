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
}