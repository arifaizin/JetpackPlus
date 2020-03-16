package com.arif.jetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import com.arif.jetpackpro.valueobject.Resource

class FavoriteViewModel(private var movieRepository: MovieRepository) : ViewModel() {

    fun getDataMovie(): LiveData<Resource<PagedList<MovieModel>>> = movieRepository.getFavoriteMovies()

    fun getDataTvShow(): LiveData<Resource<PagedList<TvShowModel>>> = movieRepository.getFavoriteTvShow()
}

