package com.arifaizin.favorite.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource

class FavoriteViewModel(private var movieRepository: MovieRepository) : ViewModel() {

    fun getDataMovie(): LiveData<Resource<PagedList<MovieModel>>> = movieRepository.getFavoriteMovies()

    fun getDataTvShow(): LiveData<Resource<PagedList<TvShowModel>>> = movieRepository.getFavoriteTvShow()
}

