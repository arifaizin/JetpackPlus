package com.arifaizin.jetpackpro.favorite.dagger

import com.arifaizin.core.data.datasource.MovieRepository
import com.arifaizin.core.di.scope.AppScope
import com.arifaizin.core.domain.FavoriteInteractor
import com.arifaizin.core.domain.FavoriteUseCase
import dagger.Module
import dagger.Provides

@Module
class FavoriteModule(){
    @AppScope
    @Provides
    fun provideUseCase(repository: MovieRepository): FavoriteUseCase = FavoriteInteractor(repository)
}