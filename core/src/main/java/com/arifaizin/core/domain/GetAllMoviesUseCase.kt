package com.arifaizin.core.domain

import com.arifaizin.core.data.datasource.MovieRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(private var movieRepository: MovieRepository) {
    operator fun invoke(page: Int) = movieRepository.getAllMovies(page)
}