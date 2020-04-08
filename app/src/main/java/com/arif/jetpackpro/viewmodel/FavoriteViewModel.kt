package com.arif.jetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifaizin.core.datasource.MovieRepository
import com.arifaizin.core.model.movie.MovieModel
import com.arifaizin.core.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource

class FavoriteViewModel(private var movieRepository: MovieRepository) : ViewModel() {

    fun getDataMovie(): LiveData<Resource<PagedList<MovieModel>>> = movieRepository.getFavoriteMovies()

    fun getDataTvShow(): LiveData<Resource<PagedList<TvShowModel>>> = movieRepository.getFavoriteTvShow()
}

