package com.arif.jetpackpro.room

import androidx.annotation.WorkerThread
import androidx.paging.DataSource
import androidx.room.*
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel

@Dao
interface MovieDao {
    //movie
    @WorkerThread
    @Query("SELECT * FROM movie")
    fun getMovies(): DataSource.Factory<Int, MovieModel>

    @WorkerThread
    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<MovieModel>): LongArray

    @Update
    fun updateMovie(movie: MovieModel): Int

    //tvshow
    @WorkerThread
    @androidx.room.Query("SELECT * FROM tvShow")
    fun getTvShow(): DataSource.Factory<Int,TvShowModel>

    @WorkerThread
    @Query("SELECT * FROM tvShow where isFavorite = 1")
    fun getFavoriteTvShow(): DataSource.Factory<Int,TvShowModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(movie: List<TvShowModel>): LongArray

    @Update
    fun updateTvShow(movie: TvShowModel): Int
}