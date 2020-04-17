package com.arifaizin.jetpackpro.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.core.domain.FavoriteInteractor
import javax.inject.Inject

@AppScope
//TODO 1: Add @Inject - Dagger tau bagaimana ViewModelFactoey dibuat, namun masih belum tau bagaimana MovieRepository dibuat
class FavoriteViewModelFactory @Inject constructor(private val favoriteInteractor: FavoriteInteractor) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> FavoriteViewModel(
                favoriteInteractor
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}