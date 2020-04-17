package com.arifaizin.core.domain

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource

interface FavoriteUseCase {
    fun getFavoriteMovies(): LiveData<Resource<PagedList<MovieModel>>>
    fun getFavoriteTvShow(): LiveData<Resource<PagedList<TvShowModel>>>
}