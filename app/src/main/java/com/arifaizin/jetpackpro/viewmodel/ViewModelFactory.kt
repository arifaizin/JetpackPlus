package com.arifaizin.jetpackpro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.core.domain.GetAllMoviesUseCase
import com.arifaizin.core.domain.GetAllTvShowUseCase
import javax.inject.Inject

@AppScope
//TODO 1: Add @Inject - Dagger tau bagaimana ViewModelFactoey dibuat, namun masih belum tau bagaimana MovieRepository dibuat
class ViewModelFactory @Inject constructor(
    private var movieRepository: MovieRepository,
    private var getAllMoviesUseCase: GetAllMoviesUseCase,
    private var getAllTvShowUseCase: GetAllTvShowUseCase
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(getAllMoviesUseCase, getAllTvShowUseCase) as T
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> DetailMovieViewModel(movieRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}