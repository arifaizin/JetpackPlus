package com.arifaizin.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arifaizin.core.datasource.MovieRepository
import com.arifaizin.core.di.scope.AppScope
import javax.inject.Inject

@AppScope
//TODO 1: Add @Inject - Dagger tau bagaimana ViewModelFactoey dibuat, namun masih belum tau bagaimana MovieRepository dibuat
class FavoriteViewModelFactory @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(
                movieRepository
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}