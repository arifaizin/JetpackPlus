package com.arif.jetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import com.arif.jetpackpro.datasource.MovieRepository
import com.arif.jetpackpro.model.movie.MovieModel
import com.arif.jetpackpro.model.tvshow.TvShowModel
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(private var movieRepository: MovieRepository) : ViewModel() {
    fun setFavoriteMovie(dataMovie: MovieModel, newStatus:Boolean) =
        movieRepository.setFavoriteMovie(dataMovie, newStatus)

    fun setFavoriteTvShow(dataMovie: TvShowModel, newStatus:Boolean) =
        movieRepository.setFavoriteTvShow(dataMovie, newStatus)
}

