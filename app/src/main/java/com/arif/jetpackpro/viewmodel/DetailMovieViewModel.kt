package com.arif.jetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.data.model.movie.MovieModel
import com.arifaizin.core.data.model.tvshow.TvShowModel

class DetailMovieViewModel(private var movieRepository: MovieRepository) : ViewModel() {
    fun setFavoriteMovie(dataMovie: MovieModel, newStatus:Boolean) =
        movieRepository.setFavoriteMovie(dataMovie, newStatus)

    fun setFavoriteTvShow(dataMovie: TvShowModel, newStatus:Boolean) =
        movieRepository.setFavoriteTvShow(dataMovie, newStatus)
}

