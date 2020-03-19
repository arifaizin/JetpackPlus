package com.arif.jetpackpro.datasource.local

import androidx.paging.DataSource
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.room.MovieDao
import javax.inject.Singleton

class LocalRepository constructor(private val mMovieDao: MovieDao) {

    fun getAllMoviesAsPaged(): DataSource.Factory<Int, MovieModel> = mMovieDao.getMovies()

    fun getFavoriteMoviesAsPaged(): DataSource.Factory<Int, MovieModel> = mMovieDao.getFavoriteMovie()

    fun insertMovie(movie: List<MovieModel>) {
        mMovieDao.insertMovies(movie)
    }

    fun setFavoriteMovie(movie: MovieModel, state: Boolean) {
        movie.isFavorite = state
        mMovieDao.updateMovie(movie)
    }

    fun getAllTvShowAsPaged(): DataSource.Factory<Int, TvShowModel> = mMovieDao.getTvShow()

    fun getFavoriteTvShowAsPaged(): DataSource.Factory<Int, TvShowModel> = mMovieDao.getFavoriteTvShow()

    fun insertTvShow(tvShow: List<TvShowModel>) {
        mMovieDao.insertTvShow(tvShow)
    }

    fun setFavoriteTvShow(tvShow: TvShowModel, state: Boolean) {
        tvShow.isFavorite = state
        mMovieDao.updateTvShow(tvShow)
    }

    companion object {
        private var INSTANCE: LocalRepository? = null

        fun getInstance(academyDao: MovieDao): LocalRepository {
            if (INSTANCE == null) {
                INSTANCE = LocalRepository(academyDao)
            }
            return INSTANCE as LocalRepository
        }
    }
}