package com.arifaizin.jetpackpro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel
import com.arifaizin.core.valueobject.Resource

class MovieViewModel(private var movieRepository: MovieRepository) : ViewModel() {

    fun getDataMovie(page: Int): LiveData<Resource<PagedList<MovieModel>>> = movieRepository.getAllMovies(page)

    fun getDataTvShow(): LiveData<Resource<PagedList<TvShowModel>>> = movieRepository.getAllTvShow()
}
