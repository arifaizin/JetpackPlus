package com.arif.jetpackpro.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arif.jetpackpro.viewmodel.DetailMovieViewModel
import com.arif.jetpackpro.viewmodel.FavoriteViewModel
import com.arif.jetpackpro.viewmodel.MovieViewModel
import com.arif.jetpackpro.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    abstract fun bindUserViewModel(movieViewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    abstract fun bindSearchViewModel(detailMovieViewModel: DetailMovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindRepoViewModel(favoriteViewModel: FavoriteViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}