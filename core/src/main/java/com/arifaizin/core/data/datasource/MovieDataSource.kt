package com.arifaizin.core.data.datasource

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource

interface MovieDataSource {
    fun getAllMovies(page: Int): LiveData<Resource<PagedList<MovieModel>>>
    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowModel>>>

    fun getFavoriteMovies(): LiveData<Resource<PagedList<MovieModel>>>
    fun getFavoriteTvShow(): LiveData<Resource<PagedList<TvShowModel>>>

    fun setFavoriteMovie(course: MovieModel, state: Boolean)
    fun setFavoriteTvShow(course: TvShowModel, state: Boolean)
}