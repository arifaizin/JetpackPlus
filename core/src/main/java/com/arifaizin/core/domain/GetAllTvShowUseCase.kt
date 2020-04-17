package com.arifaizin.core.domain

import com.arifaizin.core.data.datasource.MovieRepository
import javax.inject.Inject

class GetAllTvShowUseCase @Inject constructor(private var movieRepository: MovieRepository) {
    operator fun invoke() = movieRepository.getAllTvShow()
}