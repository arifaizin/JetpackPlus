package com.arif.jetpackpro.datasource

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.valueobject.Resource

interface MovieDataSource {
    fun getAllMovies(page: Int): LiveData<Resource<PagedList<MovieModel>>>
    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowModel>>>

    fun getFavoriteMovies(): LiveData<Resource<PagedList<MovieModel>>>
    fun getFavoriteTvShow(): LiveData<Resource<PagedList<TvShowModel>>>

    fun setFavoriteMovie(course: MovieModel, state: Boolean)
    fun setFavoriteTvShow(course: TvShowModel, state: Boolean)
}