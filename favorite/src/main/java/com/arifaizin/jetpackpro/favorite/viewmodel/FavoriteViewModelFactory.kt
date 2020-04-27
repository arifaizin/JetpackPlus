package com.arifaizin.jetpackpro.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.core.domain.FavoriteUseCase
import javax.inject.Inject

@AppScope
class FavoriteViewModelFactory @Inject constructor(private val favoriteUseCase: FavoriteUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(favoriteUseCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}